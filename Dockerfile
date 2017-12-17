FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} sheet-storage-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","sheet-storage-0.0.1-SNAPSHOT.jar"]
