package com.alekslitvinenk

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.alekslitvinenk.domain.client.Protocol.PathResponse
import com.alekslitvinenk.domain.client.ProtocolFormat.{JsonSupport, _}
import com.alekslitvinenk.domain.{CompoundBoard, Position, Step}
import com.alekslitvinenk.service.CompoundBoardPathFinder

import scala.concurrent.{ExecutionContext, Future}
import scala.io.StdIn

object Main extends App with JsonSupport {
  
  private implicit val system: ActorSystem = ActorSystem("my-system")
  private implicit val materializer: ActorMaterializer = ActorMaterializer()
  private implicit val executionContext: ExecutionContext = system.dispatcher
  
  private val pathFinder = CompoundBoardPathFinder(CompoundBoard(5))
  
  val route =
    path("path") {
      get {
        parameter('x.as[Int], 'y.as[Int]) { (x, y) =>
          val startPosition = Step(Position(x, y))
          onSuccess(Future { pathFinder.traverseAllTilesDepthFirst(startPosition) }) { result =>
            complete(PathResponse(result))
          }
        }
      }
    } ~ pathSingleSlash {
      redirect("index.html", StatusCodes.PermanentRedirect)
    } ~ {
      getFromResourceDirectory("web")
    }
  
  val bindingFuture = Http().bindAndHandle(route, "0.0.0.0",8080)
  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
