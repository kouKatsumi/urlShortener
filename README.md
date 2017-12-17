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

Service exposes POST endpoints for adding new music sheets. Separately or as a list in JSON.

Example payload for input new sheet:
```
   {
        "bookTitle": "title",
        "page": 9,
        "scale": "BASS"
    }
```
For list:
```
POST <host>:<port>/sheets
```
And for single entries:
```
POST <host>:<port>/sheets/sheet
```
To retrieve entries GET endpoints should be used:
`GET <host>:<port>/sheets/<uuid>` for a details on sheet.
`GET <host>:<port>/sheets/<uuid>/scale` for information about scale for sheet.
`GET <host>:<port>/sheets?title=<title>` for all the sheets form a book with give title .
`GET <host>:<port>/sheets?scale=<scale>` for all sheets with a given scale.



