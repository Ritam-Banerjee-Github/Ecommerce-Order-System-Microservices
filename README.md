# 🛒 E-Commerce Order Processing System – Spring Boot Microservices Project

This is a full-fledged **E-Commerce Order Processing System** built using **Java, Spring Boot 3.3.1**, and **Spring Cloud**. It demonstrates microservices architecture using real-world design patterns like **Factory**, **Strategy**, **Observer**, **Builder**, and incorporates resilience through **Resilience4j Circuit Breaker**.

---

## 🧩 Tech Stack

| Layer              | Technology Used                          |
|-------------------|-------------------------------------------|
| Backend Framework | Spring Boot 3.3.1                         |
| Database          | PostgresSQL 15                       |
| Microservices     | REST APIs, Eureka, Config Server          |
| Communication     | Feign Client, API Gateway (Spring Cloud) |
| Fault Tolerance   | Resilience4j Circuit Breaker              |
| Build Tool        | Maven                                     |
| Version Control   | Git + GitHub                              |
| IDE               | IntelliJ / VS Code                        |
| Java Version      | Java 17                                   |

---

## ⚙️ Microservices Used

| Microservice     | Port | Description                                                                 |
|------------------|------|-----------------------------------------------------------------------------|
| `config-server`  | 8888 | Centralized config management                                               |
| `discovery-server` | 8761 | Netflix Eureka for service registration/discovery                          |
| `inventory-service` | 8082 | Stores product quantity by SKU code                                        |
| `payment-service`   | 8083 | Implements different payment methods (with Factory, Strategy, Builder)     |
| `order-service`     | 8081 | Coordinates Inventory & Payment. Uses Observer Pattern + Circuit Breaker   |
| `api-gateway`       | 8080 | Routes external requests to appropriate services                           |

---

## 🎯 Features

✅ Microservices-based design  
✅ Service Discovery with Eureka  
✅ Config Server integration  
✅ Factory, Strategy, Observer & Builder Design Patterns  
✅ Circuit Breaker using Resilience4j  
✅ API Gateway routing  
✅ Clean layered architecture with DTOs  
✅ Exception Handling  
✅ Extensible & Open-Close Principle compliance  

---

## 🧱 Design Patterns Used

| Pattern    | Where & Why                                                                 |
|------------|------------------------------------------------------------------------------|
| **Factory**    | Payment method creation (`CreditCard`, `DebitCard`, `Cash`, `GPay`, etc.)  |
| **Strategy**   | Cashback logic per payment type (shared for UPI methods)                  |
| **Observer**   | Notify other systems (e.g., Inventory) after Order is placed              |
| **Builder**    | Construct immutable Payment object with fluent builder                    |

---

## 🚀 Setup Instructions

1. **Clone this repo**
   ```bash
   git clone https://github.com/your-username/ecommerce-order-processing.git
   cd ecommerce-order-processing
