# Hexagonal Architecture Spring Boot

## Description

A Java project template implementing hexagonal architecture with Spring Boot in a multi-module Maven setup. This project
provides a REST API for managing books, utilizing the principles of hexagonal architecture to maintain a clean
separation of concerns.

## Project Structure

The project is organized into several modules, each responsible for different aspects of the application:

```bash
.
├── api/ # Contains API-related modules
│   ├── adapter-data-loader/ # Module responsible for loading initial data into the application 
│   └── adapter-rest/ # Module that implements REST controllers for the API 
├── application/ # Contains application-specific logic
│   ├── annotation/ # Custom annotations used
│   └── service/ # Business logic services
├── bootstrap/ # Entry point of the application, including main class and configurations
├── deploy/ # Deployment configurations
│   └── compose/ # Contains Docker Compose files for running services
│       └── compose.yml # Docker Compose configuration for the application
├── domain/ # Core domain logic, including entities, ports and exceptions
│   ├── domain/ # Contains the domain model
│   ├── exception/ # Custom exception classes used in the domain
│   └── ports/ # Interfaces defining the input and output 
│       ├── input/ # Input ports (e.g., services) for application use cases
│       └── output/ # Output ports (e.g., repositories) for data persistence
├── LICENSE # License file for the project
├── pom.xml # Parent Maven POM file for the entire project
├── README.md
└── spi/ # Service Provider Interfaces for infrastructure
    └── adapter-spring-data-jpa/ # Spring Data JPA implementation for data access

```

## Prerequisites

- JDK 21 or later
- Apache Maven
- Docker

## Installation

### 1. Clone the repository

```bash
git clone git@github.com:jeremw264/hexagonal-architecture-springboot.git
cd hexagonal-architecture-springboot
```

### 2. Build the project

Use Maven to compile the project and resolve dependencies.

```bash
mvn clean install
```

### 3. Deploy the services with Docker Compose

A `compose.yml` file is provided to deploy the necessary services.

```bash
cd deploy/compose
docker-compose up -d
```

This compose file will deploy the following services:

- **PostgreSQL** :
    - **postgres_books** : Database for managing books.

### 4. Run the services locally

After starting the services with Docker Compose, you can run the Spring Boot services locally using Maven.

```bash
mvn spring-boot:run -pl bootstrap
```

### 5. Access the Swagger UI

For the application Swagger : [Swagger UI](http://localhost:8080/swagger-ui/index.html#/)

