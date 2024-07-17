# Player Management API

## Overview

Player Management API is a Spring Boot application that provides RESTful endpoints for managing player information. It includes functionality for creating, reading, updating, and deleting players, and utilizes DTOs (Data Transfer Objects) for data transfer between layers.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Jakarta Validation
- Lombok
- Maven
- Docker Desktop

## Project Structure

- `src/main/java/com/game/api/player/controller`: Contains REST controllers.
- `src/main/java/com/game/api/player/dto`: Contains Data Transfer Object classes.
- `src/main/java/com/game/api/player/entity`: Contains JPA entity classes.
- `src/main/java/com/game/api/player/repository`: Contains repository interfaces.
- `src/main/java/com/game/api/player/service`: Contains service classes.

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven
- Docker Desktop

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DiogoBarrosMartins/newspring
   cd newspring
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
    docker compose up -d
   ```

4. The application will be available at `http://localhost:8080`.

## API Endpoints

### Get All Players

- **URL**: `/api/players`
- **Method**: `GET`
- **Description**: Retrieve a list of all players.

### Get Player by ID

- **URL**: `/api/players/{id}`
- **Method**: `GET`
- **Description**: Retrieve a player by their ID.
- **Path Variable**:
  - `id`: Long

### Create a New Player

- **URL**: `/api/players`
- **Method**: `POST`
- **Description**: Create a new player.
- **Request Body**: `PlayerDTO`

### Update an Existing Player

- **URL**: `/api/players/{id}`
- **Method**: `PATCH`
- **Description**: Update an existing player.
- **Path Variable**:
  - `id`: Long
- **Request Body**: `PlayerDTO`

### Delete a Player

- **URL**: `/api/players/{id}`
- **Method**: `DELETE`
- **Description**: Delete a player by their ID.
- **Path Variable**:
  - `id`: Long
