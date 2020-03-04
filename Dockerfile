FROM openjdk:11.0-jre
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ENTRYPOINT [ "java", "-cp", "ChessPieceMoves-assembly-0.1.jar", "com.alekslitvinenk.Main" ]
EXPOSE 8080/tcp
CMD [ "$@" ]