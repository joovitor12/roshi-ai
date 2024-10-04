FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y consul

COPY target/roshi-0.0.1-SNAPSHOT.jar /app/roshi-0.0.1-SNAPSHOT.jar
COPY start.sh /app/start.sh

RUN chmod +x /app/start.sh

EXPOSE 8080 8500

ENTRYPOINT ["/app/start.sh"]
