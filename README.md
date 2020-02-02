# ChessPieceMove

The application is meant to cunsume the starting position of a chess piece and produce the path by following which the peice will visit all the tiles on a board (10x10). App will render the produced path on a web page via bundled web application.

## Test
To run unit tests type `sbt test`

## Build
To build the app run `./build.sh`

## Run
1. To run the app type `docker run -p 8080:8080 alekslitvinenk/chess-piece-move`
2. Go to `http://localhost:8080/`
3. Type in the form chess piece starting position
4. Hit "Find and Play" button
5. Observe piece moving animation
