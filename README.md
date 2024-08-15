# Dynamic Thread Pool Management in Spring Boot

This is a Spring Boot application that dynamically adjusts the thread pool size based on HTTP request load. It scales the thread pool up or down depending on the number of concurrent requests, optimizing resource usage and application performance.

## Features

- Dynamic scaling of the thread pool based on the current load.
- Custom thread pool configuration using `ThreadPoolExecutor`.
- Example REST API to demonstrate the dynamic thread pool behavior.

## Prerequisites

- **Java 11** or higher
- IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/shishirkpd/dynamic-threading.git
cd dynamic-threading
```

### 2. Build the Project
Use Maven to build the project:
```bash
mvn clean install
```

### 3. Run the Application
You can start the Spring Boot application using the Maven Spring Boot plugin:

```bash
mvn spring-boot:run
```
Alternatively, you can run the JAR file after building the project:
```bash
java -jar target/dynamic-thread-pool-1.0-SNAPSHOT.jar
```

### 4. Access the Application
Once the application is running, you can access it at:
```bash
http://localhost:8080/api/threads
```
This endpoint will return the current thread name handling the request.



## Testing the Application

### Manual Testing
You can manually test the dynamic thread pool by sending multiple HTTP requests to the /api/test endpoint using tools like curl or Postman.

#### 1. Curl Example:
```bash
curl http://localhost:8080/api/threads
```
#### 2. Simulate Load:
```bash
for i in {1..100}; do curl -s http://localhost:8080/api/threads & done
```

