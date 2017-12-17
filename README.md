# spring-boot-sample-data-jpa-h2

## Requirements
- Java 8

## Includes
- Spring Boot 1.3.3
  - spring-boot-starter-web: basic web starter
  - spring-boot-starter-data-jpa: JPA witth Hibernate for DB communication
  - com.h2database:h2: H2 DB connector
- Bootstrap 3.3.6
- JQuery 1.11.3

##How to build

To build jar file run
```
mvn package
```
To clean up previous builds use
```
mvn clean
```
You can also use both
```
mvn clean package
```

## How to start

To start application use following command:
```
java -jar target/sheet-storage-0.0.1-SNAPSHOT.jar
```

Jar needs to be build first.
In case of port collision, port can be changed in application.properties file.
```
server.port = 8090
```
then repackaging is needed.

## Usage

Service exposes POST endpoint for providing URL to be shortened.

Example payload:
```
  www.google.com
```
Address to POST:
```
POST <host>:<port>/url
```

In response message payload the shortened link will be present:
```
http://localhost:8090/url/aHR0cDovL3d3dy5nb29nbGUuY29tLw==
```

To visit page use:
`GET http://localhost:8090/url/aHR0cDovL3d3dy5nb29nbGUuY29tLw==`
or open link in the browser.




