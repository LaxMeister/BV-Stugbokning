# Bygg steg för backend
FROM maven:3.8.4-openjdk-17 AS backend-build
WORKDIR /app/backend
COPY ./pom.xml ./
COPY ./src ./src

# Kör testerna först
RUN mvn test

# Om testerna lyckas, fortsätt till bygg
RUN mvn clean package

# Slutlig image
FROM openjdk:17-jdk-slim AS final
WORKDIR /app
COPY --from=backend-build /app/backend/target/*.jar backend.jar

# Exponera backend port
EXPOSE 8080

# Starta backend
CMD ["java", "-jar", "backend.jar"]
