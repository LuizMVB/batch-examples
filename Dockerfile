# Use the generated image as the base image
FROM openjdk:11-jdk-slim-buster

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

# Copy your application jar and set the working directory
WORKDIR /opt/app
COPY /target/*.jar app.jar

# Copy configuration files to etc/config/batch-examples
COPY /src/main/resources/log4j.xml /etc/config/batch-examples/log4j.xml
COPY /src/main/resources/application.yml /etc/config/batch-examples/application.yml

# Use bash as the shell
SHELL ["/bin/bash", "-c"]

# Expose ports and define the command to run your Spring Boot app
EXPOSE 8080
EXPOSE 5005
CMD java ${ADDITIONAL_OPTS} -jar app.jar --spring.profile.active=${PROFILE}
