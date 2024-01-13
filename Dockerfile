FROM openjdk:17-oracle
RUN mkdir app
COPY target/amigo-secreto-project-1.0.jar /app/amigo-secreto-project-1.0.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT java -jar amigo-secreto-project-1.0.jar