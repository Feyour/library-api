# Стадия сборки
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Стадия запуска
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/library-api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]