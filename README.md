# Manufacturer Search API

## Overview

The **Manufacturer Search API** is a RESTFul API developed using **Spring Boot**. It allows users to search for manufacturers based on specific criteria such as location, nature of business, and manufacturing processes. The project is designed with best practices in mind, including secure handling of data, validation, and exception handling.

## Features

- **Search Manufacturers**: Retrieve a list of manufacturers based on location, nature of business, and manufacturing processes.

## Tech Stack

- **Java**: Programming language.
- **Spring Boot**: Framework for building the API.
- **H2 Database**: In-memory database used for development and testing.


## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com.example.manufacturer/
│   │   │   ├── controller/
│   │   │   │   └── SupplierController.java
│   │   │   ├── dto/
│   │   │   │   ├── ManufacturerDTO.java
│   │   │   │   └── SupplierDTO.java
│   │   │   ├── entity/
│   │   │   │   ├── ManufacturerEntity.java
│   │   │   │   └── SupplierEntity.java
│   │   │   ├── repository/
│   │   │   │   └── SupplierRepository.java
│   │   │   ├── service/
│   │   │   │   └── SupplierService.java
│   │   │   └── config/
│   │   │       ├── SecurityConfig.java
│   │   │       └── SwaggerConfig.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com.example.manufacturer/
            ├── SupplierServiceTest.java
            └── SupplierControllerTest.java
```

## Getting Started

### Prerequisites

- **Java 17+**: Ensure you have JDK 17 or higher installed.
- **Maven**: For building the project.

### Running the Application

1. **Clone the repository**:
    ```bash
    git clone https://github.com/negianoop/manufacturer-search-api.git
    cd manufacturer-search-api
    ```

2. **Build the project**:
    ```bash
    mvn clean install
    ```

3. **Run the application**:
    ```bash
    mvn spring-boot:run
    ```

4. **Test the API Endpoints**:
    - Make a POST request either with curl or postman at `http://localhost:8080/suppliers` 
     with the following format 
     ```bash
        {
            "companyName": "DEF Manufacturing",
            "website": "https://abc-manufacturing.com",
            "location": "New York",
            "natureOfBusiness": "LARGE_SCALE",
            "manufacturingProcesses": ["_3DPRINTING","COATING"]
        }
     ```

    - Make a GET request at `http://localhost:8080/suppliers`. 
      for example --
      ```bash 
         http://localhost:8080/suppliers?location=New%20York&natureOfBusiness=LARGE_SCALE&manufacturingProcesses=COATING, _3DPRINTING&limit=10
      ```