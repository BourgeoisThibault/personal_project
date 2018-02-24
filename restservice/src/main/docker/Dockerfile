FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD ${JAR_FILE} myapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]