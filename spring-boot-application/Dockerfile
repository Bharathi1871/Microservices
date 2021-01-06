FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8085
COPY target/spring-boot-application-0.0.1-SNAPSHOT.jar /spring-boot-application.jar
ENTRYPOINT [ "sh", "-c", "java -jar /spring-boot-application.jar"]