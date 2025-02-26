FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
WORKDIR /app
COPY --from=build /app/target/cadastro-pessoas-0.0.1-SNAPSHOT.jar myapp.jar
CMD ["java", "-jar", "myapp.jar"]