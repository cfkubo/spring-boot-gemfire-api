# Spring Boot Gemfire API

This project is a Spring Boot application that provides a RESTful API for performing operations on Apache Gemfire. It exposes endpoints for storing and retrieving data, and includes support for Spring Actuator, Swagger, and OpenAPI for easy testing and monitoring.

## Project Structure

```
springboot-gemfire-api
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── gemfireapi
│   │   │               ├── controller
│   │   │               │   └── GemfireController.java
│   │   │               ├── service
│   │   │               │   └── GemfireService.java
│   │   │               ├── config
│   │   │               │   └── GemfireConfig.java
│   │   │               └── GemfireApiApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── gemfireapi
│                       └── GemfireApiApplicationTests.java
├── pom.xml
└── README.md
```

## Features

- **RESTful API**: Provides endpoints for PUT and GET operations on Gemfire.
- **Spring Actuator**: Enables monitoring and management of the application.
- **Swagger/OpenAPI**: Automatically generates API documentation and provides a UI for testing endpoints.

## Endpoints

- **PUT /put**: Store data in Gemfire.
- **GET /get**: Retrieve data from Gemfire.


```
create region --name=exampleRegion --type=REPLICATE
```

```
curl -X PUT "http://localhost:8881/api/put?key=myKeyarul&value=demo"
```

```
curl "http://localhost:8881/api/get?key=myKeyarul"
```

## Setup Instructions

1. Clone the repository:
   ```
   git clone https://github.com/cfkubo/spring-boot-gemfire-api
   cd spring-boot-gemfire-api
   ```

2. Build the project using Maven:
   ```
   mvn clean install
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

4. Access the Swagger UI at `http://localhost:8080/swagger-ui/` to test the API endpoints.

## Dependencies

This project uses the following dependencies:

- Spring Boot
- Spring Data Gemfire
- Spring Actuator
- Swagger/OpenAPI

## License

This project is licensed under the MIT License. See the LICENSE file for more details.