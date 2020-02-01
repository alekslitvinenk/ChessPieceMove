#!/usr/bin/env bash

rm -R target

sbt ';clean ;assembly'

docker build -f Dockerfile -t alekslitvinenk/chess-piece-move ./target/scala-2.12