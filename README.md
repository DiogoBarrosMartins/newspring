# Player Management API

## Overview

Player Management API is a Spring Boot application that provides RESTful endpoints for managing player information. It includes functionality for creating, reading, updating, and deleting players, and utilizes DTOs (Data Transfer Objects) for data transfer between layers.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Maven
- Docker 

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven
- Docker Desktop

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DiogoBarrosMartins/newspring
   cd api
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
    docker compose up -build
   ```

4. The application will be available at `http://localhost:8080`.

## API Endpoints

### Account Endpoints

#### Get all accounts
- **URL:** `/accounts`
- **Method:** `GET`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body: None
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        [
            {
                "id": 1,
                "username": "john_doe",
                "password": "password123",
                "villageIds": [1, 2]
            },
            ...
        ]
        ```

#### Get account by ID
- **URL:** `/accounts/{id}`
- **Method:** `GET`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body: None
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        {
            "id": 1,
            "username": "john_doe",
            "password": "password123",
            "villageIds": [1, 2]
        }
        ```

#### Create a new account
- **URL:** `/accounts`
- **Method:** `POST`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body:
        ```json
        {
            "username": "john_doe",
            "password": "password123"
        }
        ```
- **Response:**
    - Status: `201 Created`
    - Body:
        ```json
        {
            "id": 1,
            "username": "john_doe",
            "password": "password123",
            "villageIds": []
        }
        ```

#### Update an account
- **URL:** `/accounts/{id}`
- **Method:** `PUT`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body:
        ```json
        {
            "username": "john_doe_updated",
            "password": "newpassword123"
        }
        ```
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        {
            "id": 1,
            "username": "john_doe_updated",
            "password": "newpassword123",
            "villageIds": [1, 2]
        }
        ```

#### Delete an account
- **URL:** `/accounts/{id}`
- **Method:** `DELETE`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body: None
- **Response:**
    - Status: `204 No Content`
    - Body: None

#### Authenticate account
- **URL:** `/accounts/authenticate`
- **Method:** `POST`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body:
        ```json
        {
            "username": "john_doe",
            "password": "password123"
        }
        ```
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        {
            "authenticated": true
        }
        ```

### Village Endpoints

#### Get all villages
- **URL:** `/villages`
- **Method:** `GET`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body: None
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        [
            {
                "id": 1,
                "name": "Village 1",
                "accountId": 1
            },
            ...
        ]
        ```

#### Get village by ID
- **URL:** `/villages/{id}`
- **Method:** `GET`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body: None
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        {
            "id": 1,
            "name": "Village 1",
            "accountId": 1
        }
        ```

#### Create a new village
- **URL:** `/villages`
- **Method:** `POST`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body:
        ```json
        {
            "name": "Village 1",
            "accountId": 1
        }
        ```
- **Response:**
    - Status: `201 Created`
    - Body:
        ```json
        {
            "id": 1,
            "name": "Village 1",
            "accountId": 1
        }
        ```

#### Update a village
- **URL:** `/villages/{id}`
- **Method:** `PUT`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body:
        ```json
        {
            "name": "Updated Village",
            "accountId": 1
        }
        ```
- **Response:**
    - Status: `200 OK`
    - Body:
        ```json
        {
            "id": 1,
            "name": "Updated Village",
            "accountId": 1
        }
        ```

#### Delete a village
- **URL:** `/villages/{id}`
- **Method:** `DELETE`
- **Request:**
    - Headers: `Content-Type: application/json`
    - Body: None
- **Response:**
    - Status: `204 No Content`
    - Body: None
