# 🚀 Developer Portfolio REST API

A **Spring Boot RESTful backend** for managing a developer portfolio.
This API powers a portfolio website by providing endpoints for **projects, blogs, metrics dashboard, and notifications**.

The application follows **clean architecture principles**, supports **event-driven notifications**, and includes **monitoring and API documentation**.

---

# 📌 Features

### 🧩 Core Modules

* **Project Management**

  * Create, update, delete, and fetch portfolio projects
* **Blog Management**

  * CRUD APIs for blog posts
* **Metrics Dashboard**

  * Track site visits and project views
  * Aggregated dashboard statistics
* **Notification System**

  * Event-driven notification when a new project is created
* **Global Exception Handling**

  * Consistent API error responses
* **API Documentation**

  * Swagger / OpenAPI integration
* **Application Monitoring**

  * Spring Boot Actuator for health and metrics

---

# 🏗 Architecture

The application follows a **layered architecture**:

```
Controller → Service → Repository → Database
```

For notifications, an **Event-Driven Architecture** is implemented:

```
ProjectService
      │
      ▼
ProjectCreatedEvent
      │
      ▼
NotificationListener
      │
      ▼
NotificationService
```

This ensures **loose coupling between business logic and notification logic**.

---

# 🛠 Technology Stack

### Backend

* **Java 17+**
* **Spring Boot**
* **Spring Web (REST APIs)**
* **Spring Data JPA**
* **Spring Validation**
* **Spring Events (Event-driven architecture)**

### Database

* **MySQL**

### API Documentation

* **SpringDoc OpenAPI (Swagger UI)**

### Monitoring

* **Spring Boot Actuator**

### Mapping & Utilities

* **ModelMapper**
* **Lombok**

### Build Tool

* **Maven**

---

# 📂 Project Structure

```
src/main/java/com/portfolio

├── controller          # REST API controllers
├── service             # Business logic
├── repository          # Data access layer
├── model               # JPA entities
├── dto                 # Data transfer objects
├── events              # Application events
├── listeners           # Event listeners
├── notification        # Notification services
├── exception           # Custom exceptions & handlers
└── config              # Configuration classes
```

---

# 📊 API Modules

## Projects API

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| GET    | /api/projects      | Get all projects  |
| GET    | /api/projects/{id} | Get project by ID |
| POST   | /api/projects      | Create project    |
| PUT    | /api/projects/{id} | Update project    |
| DELETE | /api/projects/{id} | Delete project    |

---

## Blogs API

| Method | Endpoint        | Description        |
| ------ | --------------- | ------------------ |
| GET    | /api/blogs      | Get all blog posts |
| GET    | /api/blogs/{id} | Get blog by ID     |
| POST   | /api/blogs      | Create blog post   |
| PUT    | /api/blogs/{id} | Update blog        |
| DELETE | /api/blogs/{id} | Delete blog        |

---

## Metrics Dashboard

Tracks:

* Website visits
* Project views
* Overall dashboard statistics

Example endpoint:

```
GET /api/metrics/dashboard
```

---

# 📑 API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

# ⚙️ Monitoring

Spring Boot Actuator provides system insights.

Endpoints:

```
/actuator/health
/actuator/metrics
/actuator/env
/actuator/loggers
```

---

# 🔔 Event-Driven Notifications

When a project is created:

```
POST /api/projects
```

The system publishes:

```
ProjectCreatedEvent
```

Which triggers:

```
NotificationListener → NotificationService
```

Future extensions:

* Email notifications
* WebSocket real-time alerts
* Notification history storage

---

# 🧪 Example API Response

```json
{
  "success": true,
  "message": "Project created successfully",
  "data": {
    "id": 1,
    "title": "Portfolio Backend",
    "description": "Spring Boot API for developer portfolio",
    "techStack": "Spring Boot, MySQL"
  },
  "timestamp": "2026-03-14T10:20:00"
}
```

---

# 🚀 Getting Started

### 1️⃣ Clone the repository

```
git clone https://github.com/yourusername/portfolio-api.git
```

---

### 2️⃣ Configure Database

Update:

```
src/main/resources/application.yml
```

Example:

```
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/portfolio_db
    username: root
    password: password
```

---

### 3️⃣ Run the Application

```
mvn spring-boot:run
```

or

```
./mvnw spring-boot:run
```

---

# 📈 Future Enhancements

* JWT Authentication
* Email notifications
* WebSocket real-time updates
* Redis caching
* Docker containerization
* CI/CD pipeline
* Prometheus + Grafana monitoring

---

# 👨‍💻 Author

**Your Name**

Backend Developer | Java | Spring Boot

GitHub:
https://github.com/yourusername

---

# ⭐ Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

# 📜 License

This project is licensed under the **MIT License**.
