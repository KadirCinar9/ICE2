# Build stage
FROM gradle:8-jdk21-alpine AS builder

WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .

RUN ./gradlew build -x test

# Package stage
FROM openjdk:21-jdk-slim
WORKDIR /app

COPY --from=builder /home/gradle/src/build/libs/product-service-0.0.1-SNAPSHOT.jar /app/product-service.jar

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]
