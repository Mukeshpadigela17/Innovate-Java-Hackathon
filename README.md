# Innovate-Java-Hackathon

# 🔁 Retry & Replay Framework

A robust and configurable Retry & Replay Framework built with **Spring Boot** to improve system reliability and recoverability in the face of transient errors and system failures.

## 📌 Project Objective

To provide a scalable solution for handling integration failures by:

- Automatically retrying failed transactions with different strategies.
- Allowing manual replay of failed transactions via a web UI.
- Enabling observability with dashboards, logs, and notifications.

---

## 🚀 Key Features

- ✅ **Retry Mechanism** using Quartz Scheduler and Apache Camel.
  - Fixed Interval
  - Exponential Backoff
  - Circuit Breaker
  - Jitter (randomized retry delay)

- 🧪 **Event-driven retries** (Kafka Optional).

- 🔁 **Replay Process**
  - Manual transaction replay via UI.
  - Supports both stateful and stateless replays.
  - Configurable scope and timing for replays.

- 👤 **Role-Based Access Control (RBAC)**
  - Admin and user roles.
  - Secure access to retry and replay operations.

- 📊 **Monitoring Dashboard**
  - View retry/replay status.
  - Trigger manual retries.
  - Download logs/reports.

- 📬 **Notification System**
  - Email alerts for retry/replay success/failure.
  - Incident creation on persistent failure.

---

## 🛠️ Tech Stack

- **Spring Boot**
- **Quartz Scheduler**
- **Apache Camel**
- **Kafka (Optional)**
- **Spring Security (RBAC)**
- **Spring Mail**
- **Thymeleaf or React (for UI)**
- **MySQL / PostgreSQL (for storing jobs/transactions)**

---

## 📂 Folder Structure

```bash
src/
├── main/
│   ├── java/com/example/retryframework/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── strategy/
│   │   ├── service/
│   │   ├── model/
│   │   └── RetryFrameworkApplication.java
│   └── resources/
│       ├── application.yml
│       └── templates/
