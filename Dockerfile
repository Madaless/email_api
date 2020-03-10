FROM openjdk:8
ADD target/email_api-0.0.1-SNAPSHOT.jar email_api-0.0.1-SNAPSHOT.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/email_api-0.0.1-SNAPSHOT.jar"]