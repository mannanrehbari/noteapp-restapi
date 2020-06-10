FROM openjdk:8-jdk-alpine

LABEL maintainer="mannanrehbari@outlook.com"

VOLUME /tmp

EXPOSE 8089

ARG JAR_FILE=target/GospellerREST-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} gospeller-restapi.jar

ENTRYPOINT ["java", "-jar" , "/gospeller-restapi.jar"]

