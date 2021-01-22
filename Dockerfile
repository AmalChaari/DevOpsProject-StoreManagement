FROM adoptopenjdk/openjdk11:latest
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} store-managment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/store-managment-0.0.1-SNAPSHOT.jar"]