FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/roshi-0.0.1-SNAPSHOT.jar /app/roshi-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/roshi-0.0.1-SNAPSHOT.jar"]