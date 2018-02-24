FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ADD ${JAR_FILE} ${JAR_FILE}
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/${JAR_FILE}.jar"]