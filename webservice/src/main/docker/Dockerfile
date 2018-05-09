FROM openjdk:8-jdk-alpine

ADD serverweb.war myapp.war
RUN sh -c 'touch /myapp.war'

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.war", "--link.rest=http://mylab_rest:25000/", "--spring.redis.host=mylab_redis"]