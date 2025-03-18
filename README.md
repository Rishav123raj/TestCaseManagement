Here’s the modified README.md content that you can copy and paste directly into your file. It retains all the formatting, indentation, and structure:

```markdown
# Test Case Management Service

A Spring Boot REST API for managing test cases, supporting CRUD operations, pagination, filtering, and validation using MongoDB.

## Features

- ✅ **CRUD Operations** (Create, Read, Update, Delete)
- ✅ **MongoDB Integration** (Spring Data MongoDB)
- ✅ **Pagination & Filtering** (status, priority)
- ✅ **Input Validation & Exception Handling**
- ✅ **Logging with SLF4J**
- ✅ **Swagger API Documentation**
- ✅ **Unit & Integration Tests**

## Technologies Used

- Java 17 + Spring Boot
- MongoDB (Spring Data MongoDB)
- JUnit 5 & Mockito (Unit Testing)
- Swagger (Springdoc OpenAPI)
- Docker (Optional)

## Project Structure

```bash
test-case-management/
│── src/
│   ├── main/java/com/example/testmanagement/
│   │   ├── controller/          # REST API Controllers
│   │   ├── service/             # Business Logic Layer
│   │   ├── repository/          # Database Layer (MongoDB)
│   │   ├── model/               # Data Models & Enums
│   │   ├── dto/                 # Data Transfer Objects
│   │   ├── exception/           # Custom Exception Handling
│   │   ├── strategy/            # Strategy Pattern for Priority
│   │   ├── utils/               # Utility Classes (Factory Pattern)
│   │   ├── config/              # Configuration (Swagger)
│   │   ├── TestCaseManagementApplication.java  # Main Class
│   ├── resources/
│   │   ├── application.properties  # App Config (MongoDB, Logging)
│   ├── test/java/com/example/testmanagement/
│   │   ├── controller/          # Integration Tests
│   │   ├── service/             # Unit Tests
│   │   ├── repository/          # Repository Tests
│── pom.xml                      # Maven Dependencies
│── README.md                    # Documentation
│── Dockerfile                   # (Optional) Docker Support
│── scripts/                     # (Optional) MongoDB Setup Scripts
```

## Setup & Installation

### 1️⃣ Prerequisites

- Java 17+
- MongoDB (Installed or running via Docker)
- Maven
- Postman (Optional, for testing API)

### 2️⃣ Clone the Repository

```sh
git clone https://github.com/your-username/test-case-management.git
cd test-case-management
```

### 3️⃣ Configure MongoDB

#### Option 1: Run Locally

Make sure MongoDB is running on port 27017:

```sh
mongod --dbpath /data/db
```

#### Option 2: Run MongoDB using Docker

```sh
docker run -d --name mongodb -p 27017:27017 mongo
```

### 4️⃣ Update Configuration (Optional)

Modify `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/testcaseDB
server.port=8080
```

### 5️⃣ Build and Run the Application

```sh
mvn clean install
mvn spring-boot:run
```

🚀 API will be available at: [http://localhost:8080](http://localhost:8080)

### 6️⃣ API Endpoints

| Method | Endpoint               | Description                              |
|--------|------------------------|------------------------------------------|
| GET    | `/api/testcases`       | Get all test cases (with pagination & filtering) |
| GET    | `/api/testcases/{id}`  | Get test case by ID                      |
| POST   | `/api/testcases`       | Create a new test case                   |
| PUT    | `/api/testcases/{id}`  | Update a test case                       |
| DELETE | `/api/testcases/{id}`  | Delete a test case                       |

## API Documentation

### Swagger UI

Once the application is running, open:

```bash
http://localhost:8080/swagger-ui.html
```

It provides an interactive API documentation where you can test endpoints.

## Sample Test Data

You can insert sample test data into MongoDB manually or use the following script:

### Option 1: Insert Test Data via Mongo Shell

```js
use testcaseDB;

db.test_cases.insertMany([
  {
    "title": "Login Test",
    "description": "Verifying user login functionality",
    "status": "PENDING",
    "priority": "HIGH",
    "createdAt": new Date(),
    "updatedAt": new Date()
  },
  {
    "title": "Signup Test",
    "description": "Checking user signup flow",
    "status": "IN_PROGRESS",
    "priority": "MEDIUM",
    "createdAt": new Date(),
    "updatedAt": new Date()
  }
]);
```

### Option 2: Insert via `data.sql`

Add the following to `src/main/resources/data.sql`:

```sql
INSERT INTO test_cases (title, description, status, priority, createdAt, updatedAt)
VALUES ('Login Test', 'Verifying login functionality', 'PENDING', 'HIGH', NOW(), NOW());

INSERT INTO test_cases (title, description, status, priority, createdAt, updatedAt)
VALUES ('Signup Test', 'Checking signup process', 'IN_PROGRESS', 'MEDIUM', NOW(), NOW());
```

Then restart the application.

## Running Tests

This project includes Unit Tests & Integration Tests.

### Run All Tests

```sh
mvn test
```

### Run Individual Tests

```sh
mvn -Dtest=TestCaseServiceTest test
mvn -Dtest=TestCaseControllerTest test
```

## Design Considerations & Trade-offs

### MongoDB vs. SQL

- **Choice:** NoSQL MongoDB
- **Reason:** Flexible schema, scalability, faster reads & writes for test case management.

### Factory Pattern for Object Creation

- **Advantage:** Decouples object instantiation from service logic.

### Strategy Pattern for Priority Management

- **Advantage:** Makes priority handling more extensible.

### Singleton Pattern for Service Layer

- **Advantage:** Ensures a single service instance for consistency.

### Exception Handling with Global Handlers

- **Advantage:** Centralized error handling makes debugging easier.

## Deployment (Optional)

You can deploy the application using Docker, Heroku, or AWS.

### Docker Deployment

#### Build Docker Image

```sh
docker build -t test-case-management .
```

#### Run Container

```sh
docker run -p 8080:8080 test-case-management
```

## Contributors

👨‍💻 **Your Name** -(https://www.github.com/Rishav123raj)

## License

This project is licensed under the MIT License.
```
