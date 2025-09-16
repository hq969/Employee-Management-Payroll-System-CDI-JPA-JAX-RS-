# Employee Management & Payroll System

A **Jakarta EE / CDI-based** Employee Management and Payroll System.  
This project demonstrates **JAX-RS REST APIs, CDI dependency injection, and JPA persistence** for managing employees and their payroll records.

---

## 📂 Project Structure

```

├── pom.xml
├── README.md
└── src
├── main
│   ├── java
│   │   └── com.example.employee
│   │       ├── AppApplication.java     # JAX-RS Application Config
│   │       ├── entity
│   │       │   ├── Employee.java
│   │       │   └── Payroll.java
│   │       ├── repo
│   │       │   └── GenericRepository.java
│   │       ├── service
│   │       │   ├── EmployeeService.java
│   │       │   └── PayrollService.java
│   │       └── rest
│   │           ├── EmployeeResource.java
│   │           └── PayrollResource.java
│   └── resources
        └── META-INF
           └── persistence.xml

````

---

## ⚙️ Technologies Used
- **Java 17+**
- **Maven**
- **Jakarta EE 10**
  - CDI (Contexts and Dependency Injection)
  - JAX-RS (REST API)
  - JPA (Jakarta Persistence API)
- **Hibernate** (JPA Provider)
- **H2 Database** (in-memory DB for demo)

---

## 🚀 Running the Project

### 1. Clone the Repository
```bash
git clone https://github.com/hq969/employee-payroll-cdi-jpa-jax-rs.git
cd employee-payroll-cdi-jpa-jax-rs
````

### 2. Build with Maven

```bash
mvn clean install
```

### 3. Deploy to Jakarta EE Runtime

You can run this with:

* **Payara Micro**
* **WildFly**
* **OpenLiberty**

Example with **Payara Micro**:

```bash
java -jar payara-micro.jar --deploy target/employee-payroll-cdi.war
```

---

## 📌 REST Endpoints

### Employee API

* `POST /api/employees` → Add new employee
* `GET /api/employees` → Get all employees
* `GET /api/employees/{id}` → Get employee by ID
* `DELETE /api/employees/{id}` → Delete employee

### Payroll API

* `POST /api/payrolls` → Add payroll entry
* `GET /api/payrolls` → Get all payrolls
* `GET /api/payrolls/{id}` → Get payroll by ID

---

## 🧪 Example API Calls (using `curl`)

### Add Employee

```bash
curl -X POST http://localhost:8080/api/employees \
     -H "Content-Type: application/json" \
     -d '{"name":"Harsh Sonkar","department":"IT","salary":50000}'
```

### Get All Employees

```bash
curl http://localhost:8080/api/employees
```

### Add Payroll Record

```bash
curl -X POST http://localhost:8080/api/payrolls \
     -H "Content-Type: application/json" \
     -d '{"employeeId":1,"month":"2025-09","amount":48000}'
```

---

## 📝 Notes

* By default, it uses **H2 in-memory DB** (check `persistence.xml`).
* Data resets every time the server restarts.
* Can be easily switched to MySQL/PostgreSQL by updating `persistence.xml`.

---

## 👨‍💻 Author

**Harsh Sonkar**
Employee Management & Payroll System with CDI, JPA, and REST.

```
