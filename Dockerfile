# Usar a imagem base do OpenJDK 11
FROM openjdk:17-jdk-slim

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o jar da aplicação para o diretório de trabalho
COPY target/roshi-0.0.1-SNAPSHOT.jar /app/roshi.jar

# Expor a porta em que a aplicação Spring Boot será executada
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "roshi.jar"]
