# Roshi-AI
<p align="center">
  <a href="#-stack">Stack</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-project">Project</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#future-works">Future works</a>&nbsp;&nbsp;|&nbsp;
  <a href="#-how-to-run">How to run</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#-collaborators">Collaborators</a>&nbsp;&nbsp;&nbsp;
</p>

<br>

## ✨ Stack

This project was developed and tested with the following technologies:

- [SpringBoot](https://spring.io/projects/spring-boot)
- [JUnit](https://junit.org/junit5/)
- [MongoDB](https://www.mongodb.com)
- [Postman](https://www.postman.com/)
- [GitHub Actions](https://docs.github.com/en/actions)
- [Consul](https://developer.hashicorp.com/consul/api-docs)
- [Docker](https://docs.docker.com)
- [Swagger](https://swagger.io)


## 💻 Project

Roshi-AI is a pioneer in the field of intelligent agents designed to enhance the experience of its users. The chosen application area is the fighting game Dragonball FighterZ, a 3v3 fighting game. The goal of this project is to ease the transition for new players who have little or no knowledge of the game's general concepts, control notation, combos, and team composition.

The project currently consists of:

- Listing and saving characters
- Translating control sequences and providing insights into game concepts and team compositions
- Listing and saving character sequences
- Saving and editing API key, insight prompt, translate prompt and team prompt


## Future works

As clarified in the previous section, the project is a pilot and has several areas for improvement, which I plan to address over time—both to enhance the user experience and to improve my own skills as a software developer. At the time of writing this documentation, we are in version 1 of the project, and we have a [repository on DockerHub](https://hub.docker.com/repository/docker/joovitm/roshi-ai/general) where the project's image is available. Currently, it only runs the Spring application, connecting to a local database and a local connection to Consul.

Areas for improvement that, should anyone be interested in contributing to the project (as it is open-source), I would consider valuable to evaluate:

- Greater consistency in unit testing for service classes
- Integration with SonarQube
- In the DockerHub image, not only providing the Spring application but also two additional containers running Consul and MongoDB for easier user access
- Train our own Roshi-AI LLM
- Script to initialize Consul with all information that the project needs (API key, insight prompt, translate prompt and team prompt)
- As mentioned above, these are just suggestions that I find interesting, but feel free to add anything you believe would improve the project!

Let me know if you'd like further refinements!


## 🚀 How to run

- Clone the repository
- Ensure you have the following dependencies installed:
   - [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
   - [Maven 3.8.5](https://maven.apache.org/docs/3.8.5/release-notes.html)
   - [Docker](https://docs.docker.com)
   - [MongoDB](https://www.mongodb.com)

- Ensure your local connection to your database (MongoDB)
- Open the repository in any IDE (e.g., IntelliJ, STS) or directly in your terminal
- Navigate to the project root directory `/roshi-ai` and run the command `docker-compose up --build` (see notes below)
- With the Docker container running, access Consul at `http://localhost:8500/ui/dc1/kv`
- In Consul, create a `config` folder and inside it, create another folder named `roshi-ai`
- Inside the `roshi-ai` folder, create the following keys: `api-key`, `insight-prompt`, `translate-prompt`, and `team-prompt` (in a future update, it'll be avaliable the prompts that have been used for this project)
- Stop the application and run `docker-compose up --build` again
- Access [`Swagger`](http://localhost:8080/swagger-ui/index.html) to view the available project endpoints and see parameter examples

Notes:

- In this current version, the Spring application will fail during the first run due to missing key creations (the prompts and API key). To resolve this, simply follow the tutorial above.

## 👷 Collaborators

#### Name: João Vitor Machado Andrade Sousa
- [GitHub](https://github.com/joovitor12)
- [LinkedIn](https://www.linkedin.com/in/jo%C3%A3o-vitor-machado-b23a7820b/)
