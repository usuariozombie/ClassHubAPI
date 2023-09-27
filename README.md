# ClassHubAPI

## Overview

Welcome to the ClassHubAPI! This API provides endpoints for managing class schedules in a Discord server. You can add, retrieve, edit, and delete class schedules using the provided RESTful endpoints.

## Getting Started

To set up and run the ClassHubAPI, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/ClassScheduleAPI.git
   cd ClassScheduleAPI
   ```

2. **Build and Run the Application:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the API:**
   The API will be accessible at `http://localhost:8080/api`.

## API Endpoints

### Add Class Schedule

- **Endpoint:** `/api/add`
- **Method:** `POST`
- **Parameters:**
  - `serverId`: Server identifier
  - `day`: Day of the class
  - `hour`: Hour of the class
  - `subject`: Subject of the class
- **Response:**
  - Success: 200 OK
  - Failure: 400 Bad Request

### Get Formatted Class Schedule

- **Endpoint:** `/api/schedule`
- **Method:** `GET`
- **Parameters:**
  - `serverId`: Server identifier
- **Response:**
  - Success: 200 OK with the formatted class schedule
  - Failure: 404 Not Found

### Edit Class Schedule

- **Endpoint:** `/api/edit`
- **Method:** `PUT`
- **Parameters:**
  - `serverId`: Server identifier
  - `day`: Day of the class
  - `hour`: Hour of the class
  - `subject`: New subject of the class
- **Response:**
  - Success: 200 OK
  - Failure: 400 Bad Request

### Delete Class Schedule

- **Endpoint:** `/api/delete`
- **Method:** `DELETE`
- **Parameters:**
  - `serverId`: Server identifier
  - `day`: Day of the class
  - `hour`: Hour of the class
- **Response:**
  - Success: 200 OK
  - Failure: 400 Bad Request

## Models

### Class Schedule

Represents a class schedule entity.

```java
@Entity
public class ClassSchedule {
    // ... (see the source code)
}
```

### Discord Server

Represents a Discord server.

```java
@Entity
public class DiscordServer {
    // ... (see the source code)
}
```

## Repositories

### Class Schedule Repository

Manages ClassSchedule entities.

```java
@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
    // ... (see the source code)
}
```

### Discord Server Repository

Manages DiscordServer entities.

```java
@Repository
public interface DiscordServerRepository extends JpaRepository<DiscordServer, Long> {
    // ... (see the source code)
}
```

## Service

### Class Schedule Service

Manages class schedules.

```java
@Service
public class ClassScheduleService {
    // ... (see the source code)
}
```

## Main Application

### Class Schedule API

Main class for starting the Class Schedule API application.

```java
@SpringBootApplication
public class ClassScheduleAPI {
    // ... (see the source code)
}
```

Feel free to explore and customize the code according to your needs!

---

*For more information, visit our [full documentation](https://usuariozombie.github.io/ClassHubAPI/classhub/docs/index.html).*


