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
## Getting Started



### Prerequisites
- gemfire up and running [https://gemfire.dev/quickstart/docker](https://gemfire.dev/quickstart/docker)
- Java 21 
- Maven
- Set Broadcom Maven Repository user credentials See https://gemfire.dev/quickstart/spring


Add Spring Boot for VMware GemFire to a Project
The Spring Boot for VMware GemFire dependencies are available from the Broadcom Support Portal. Access to the Broadcom Maven Repository requires a one-time registration step to create an account.

Spring Boot for VMware GemFire requires users to add the GemFire repository to their projects.

To add Spring Boot for VMware GemFire to a project:

1. You will need a [Broadcom Support Portal](https://support.broadcom.com/) account.

2. Select My Downloads. Search by Product Name = VMware Tanzu GemFire. Click on VMware Tanzu GemFire. Click on VMware Tanzu GemFire. Scroll down, Show All Releases, scroll down to Click Green Token for Repository Access and click on the green symbol to the far right. Note your email address. Copy your access_token (not including any surrounding quotation marks).

3. Add the GemFire repository to your project:
 
Maven: Add the following block to the pom.xml file:
```
<repository>
    <id>gemfire-release-repo</id>
    <name>Broadcom GemFire Release Repository</name>
    <url>https://packages.broadcom.com/artifactory/gemfire/</url>
</repository>
```
4. Add your Broadcom Maven Repository credentials.
Maven: Add the following to the **.m2/settings.xml** file. Replace MY-USERNAME@example and MY-ACCESS-TOKEN with your Broadcom Maven Repository credentials.

```
<settings>
    <servers>
        <server>
            <id>gemfire-release-repo</id>
            <username>MY-USERNAME@example.com</username>
            <password>MY-ACCESS-TOKEN</password>
        </server>
    </servers>
</settings>
```

5. After you have set up the repository and credentials, add the Spring Boot for VMware GemFire dependency to your application.




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