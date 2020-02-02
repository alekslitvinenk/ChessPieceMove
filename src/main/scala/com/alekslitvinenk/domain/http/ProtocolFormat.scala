package com.alekslitvinenk.domain.http

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import com.alekslitvinenk.domain.Position
import com.alekslitvinenk.domain.http.Protocol.{PathResponse, Pos}
import spray.json.DefaultJsonProtocol

object ProtocolFormat {
  
  trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
    implicit val searchFormat = jsonFormat2(Pos)
    implicit val itemFormat = jsonFormat1(PathResponse)
  }
  
  implicit def convertPositionToPos(positions: List[Position]): List[Pos] =
    positions.map(position => Pos(position.x, position.y))
}
