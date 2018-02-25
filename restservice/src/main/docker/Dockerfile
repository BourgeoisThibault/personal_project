FROM openjdk:8-jdk-alpine

ADD restservice.jar myapp.jar
RUN sh -c 'touch /myapp.jar'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar", "--spring.datasource.url=jdbc:mysql://10.10.1.4:3306/jobswitchdb?useSSL=false"]