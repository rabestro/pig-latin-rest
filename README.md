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

The application is deployed on Azure at https://piglatin.azurewebsites.net.

You can use the simple [web interface](https://piglatin.azurewebsites.net) and the [Swagger UI](https://piglatin.azurewebsites.net/swagger-ui/index.html).

Please note that the application is deployed on the free-tier F1 plan. This means that if the application is in sleep mode, it may take about a minute for the first API call to wake it up. Subsequent API calls should be faster.

## API Testing

The application includes API tests written with frameworks:
- [Karate](https://www.karatelabs.io/)
- [Bruno](https://www.usebruno.com/)
- [Hurl](https://hurl.dev/)
- [httpYac](https://httpyac.github.io/)
- [JetBrains HTTP Client](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)
- [Apache jMeter](https://jmeter.apache.org/)

### Bruno

To run the Bruno API tests, use the following commands:

```bash
cd bruno-test
npm run test
```

Successful test report:
https://github.com/rabestro/pig-latin-rest/runs/20357669812

Failed test report:
https://github.com/rabestro/pig-latin-rest/runs/20706167144#r0s1

> [!NOTE]
> Note - Bruno's script support might also be used for light test automation based on project specifics.

### JetBrains HTTP Client

[![HTTP Client - Secret Weapon for Web Service Testing](https://img.youtube.com/vi/VMUaOZ6kvJ0/default.jpg)](https://www.youtube.com/watch?v=VMUaOZ6kvJ0)

[![HTTP Client CLI](https://img.youtube.com/vi/mwiHAukbWjM/default.jpg)](https://www.youtube.com/watch?v=mwiHAukbWjM)


Successful test report:
https://github.com/rabestro/pig-latin-rest/runs/20240718373

Failed test report:
https://github.com/rabestro/pig-latin-rest/runs/20241724987

### httpYac - the Free alternative of JetBrains HTTP Client

https://httpyac.github.io/

### Karate

To run the Karate API tests, use the following command:

```bash
mvn clean test -Dtest=TestRunner
```

### Performance Testing by Apache jMeter

Load Test [Descriptive Summary/Conclusions](https://a.blazemeter.com/app/executive-summary/index.html?master_id=71758198&selectedTimeMeasure=milliseconds#/) and [Full Report](https://a.blazemeter.com/app/?public-token=N8EAygRaczgVrG5dVfzaiW08KETtECXvph3X6BDkXV6CoIi2pM#/accounts/1886840/workspaces/1958186/projects/2311430/masters/71758198/summary)
