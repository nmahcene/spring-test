FROM openjdk:8-jdk-alpine
LABEL maintainer="n_mahcene@hotmail.com"
VOLUME /tmp
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 9002
ADD target/spring-boot-test-0.0.1-SNAPSHOT.jar app.jar