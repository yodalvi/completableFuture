# CompletableFuture Dashboard Service

## 📌 Overview
This project is a **Spring Boot microservice** that demonstrates how to aggregate data from multiple tables asynchronously using **Java CompletableFuture**.  
The service fetches data from four domain tables — **Claim, Payment, FraudCheck, and Notification** — and produces a unified **dashboard summary** that can be exported to CSV.

---

## ⚙️ Architecture
- **Databases & Tables**
  - `claimdb.claim` → customer claims
  - `paymentdb.payment` → payments linked to claims
  - `frauddb.fraud_check` → fraud check results per claim
  - `notificationdb.notification` → notifications sent per claim
  - `dashboarddb.dashboard_summary` → aggregated dashboard view

- **Entities**
  - `Claim` → claim details (`id`, `customerId`, `status`)
  - `Payment` → payment info (`id`, `claimId`, `status`, `amount`)
  - `FraudCheck` → fraud check result (`id`, `claimId`, `status`)
  - `Notification` → notification message (`id`, `claimId`, `message`)

- **Service Layer**
  - Uses `CompletableFuture` to fetch data from all four repositories in parallel.
  - Aggregates results into a unified DTO (`ClaimDashboardDTO`).
  - Exports aggregated data to CSV using a utility class (`CsvWriter`).

---

## 🚀 Features
- Parallel data fetching with `CompletableFuture`
- Aggregation of multiple tables into a single dashboard view
- CSV export pipeline
- Clean separation of entities, repositories, and service logic
- MySQL schema with proper foreign keys (`claim_id`)

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **CompletableFuture API**

---

## 📂 Project Structure
