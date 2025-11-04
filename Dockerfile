FROM eclipse-temurin:21-jdk
RUN mkdir /app
WORKDIR /app
COPY target/PS_EstoqueApi-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
