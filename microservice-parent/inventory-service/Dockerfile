#----------------
#   Build Stage
#----------------
FROM gradle:8-jdk21-alpine AS builder

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build -x test

#------------
#   Package
#------------
FROM openjdk:21-jdk

RUN mkdir /app

COPY --from=builder /home/gradle/src/build/libs/inventory-service-0.0.1-SNAPSHOT.jar /app/inventory-service.jar

RUN echo "Contents of /app directory:" && ls /app

ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "/app/inventory-service.jar"]
