# Spring Boot JPA Example Project

This is a simple CRUD application built with **Spring Boot** and **Spring Data JPA**. The project demonstrates how to use JPA to perform basic database operations with an entity such as `Employee`.

## 🧰 Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL 
- Maven


## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone [https://github.com/kursathurkanaydin/spring-jpa.git]
cd spring-jpa
```

### 2. Build the Project

```bash
./mvnw clean install
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

### 4. Test the API

You can test the endpoints using Postman or curl:

```bash
curl http://localhost:8080/api/employees
```

## 🔧 Example `application.properties`

```properties
spring.application.name=restdao
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=root
spring.datasource.password=password
spring.main.banner-mode=off
logging.level.org.hibernate.SQL= debug
logging.level.org.hibernate.orm.jdbc.bind=trace

```

## 🧪 Sample REST API Endpoints

| Method | Endpoint            | Description          |
|--------|---------------------|----------------------|
| GET    | `/api/employees`        | Get all employee        |
| POST   | `/api/employees`        | Create new employee      |
| PUT    | `/api/employees/{id}`   | Update existing employee |
| DELETE | `/api/employees/{id}`   | Delete employee        |


