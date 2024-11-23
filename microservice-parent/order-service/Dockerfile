#----------------
#   Package Stage
#----------------
FROM openjdk:21-jdk

# Create the app directory
RUN mkdir /app

# Copy the pre-built JAR file (built locally) into the container
COPY ./build/libs/order-service-0.0.1-SNAPSHOT.jar /app/order-service.jar

# Set environment variables for MongoDB (optional)
ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PWD=password

# Expose the port for the service
EXPOSE 8085

# Set the entry point for the application to run the JAR
ENTRYPOINT ["java", "-jar", "/app/order-service.jar"]
