# User Orchestration API

## Overview
RESTful API for loading and managing user data from dummyjson.com

## Features
- Load users from external API to H2 database
- Search users by first name, last name, or SSN
- Get user by ID or email

## Technologies
- Java 17
- Spring Boot 3.x
- H2 Database
- Swagger/OpenAPI 3.0

## Setup
1. Clone the repository
2. Build the project: `mvn clean install`
3. Run the application using Docker
   Build - docker build -t user-api .
   Run - docker run -p 8082:8082 user-api

**Optional**
3. Run the application: `mvn spring-boot:run`

## API Documentation
Access Swagger UI at: http://localhost:8082/swagger-ui.html

## Configuration
Environment variables can be set in `application.yml`

## Testing
Run unit tests: `mvn test`
