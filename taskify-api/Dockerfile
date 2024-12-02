FROM openjdk:17
MAINTAINER gmalheiro.com
ARG JAR_FILE=target/taskify-api-0.0.1-SNAPSHOT.jar
#ARG JAR_FILE=target/*.jar
# COPY target/taskify-api-0.0.1-SNAPSHOT.jar taskify-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
