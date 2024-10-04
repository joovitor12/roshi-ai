#!/bin/bash

# Iniciar o Consul em segundo plano
consul agent -dev -client 0.0.0.0 &

# Iniciar a aplicação Java
java -jar /app/roshi-0.0.1-SNAPSHOT.jar
