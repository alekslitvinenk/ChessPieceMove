FROM openjdk:11.0-jre
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
ENTRYPOINT [ "java", "-cp", "TrueCallerAssignment-assembly-0.1.jar", "com.alekslitvinenk.Main" ]
CMD [ "$@" ]