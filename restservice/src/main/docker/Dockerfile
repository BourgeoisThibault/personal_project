FROM openjdk:8-jdk-alpine
ADD /builds/thibault.bourgeois/jobswitch/restservice/target/docker/restservice.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]