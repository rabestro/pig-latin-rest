[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lv.id.jc%3Apig-latin-rest&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=lv.id.jc%3Apig-latin-rest)
[![API docs](https://img.shields.io/badge/API-docs-informational)](https://piglatin.azurewebsites.net/swagger-ui/index.html)
[![Deployed on Azure](https://img.shields.io/badge/Deployed%20on-Azure-blue)](https://piglatin.azurewebsites.net)

# Pig Latin Translator

This is a REST application that translates English sentences into Pig Latin. The rules and instructions for the Pig Latin translation were obtained from the [Pig Latin exercise on the Exercism Java Track](https://exercism.org/tracks/java/exercises/pig-latin).

The application was created to experiment with the API-first approach: the OpenAPI specification was created first, then the code was generated for Spring, and finally, custom code was added that depends on the generated code.

## Getting Started

Before opening the code for editing, run the following command to generate the necessary code:

```bash
mvn clean compile
```

This command cleans the project, compiles the source code, and generates the code that the custom code depends on. After running this command, you should be able to open the code without getting any error messages.

## Running the Application Locally

To run the application locally, use the following command:

```bash
mvn clean compile spring-boot:run
```
This will start the application on localhost:8080. You can access the Swagger UI at http://localhost:8080/swagger-ui/ and the application endpoint at http://localhost:8080/pig-latin.

## Deployed Application

The application is deployed on Azure at the following URL: https://piglatin.azurewebsites.net.

You can use the simple web interface at https://piglatin.azurewebsites.net and the Swagger UI at https://piglatin.azurewebsites.net/swagger-ui/index.html.

## API Testing

The application includes API tests written with two frameworks: Karate and Bruno.

To run the Bruno API tests, use the following commands:

```bash
cd bruno-test
npm run test
```

To run the Karate API tests, use the following command:

```bash
mvn clean test -Dtest=TestRunner
```

## Specification-First Development

This application was developed using the specification-first approach. The specifications were written first using the Spock framework, and then the implementation was added.
