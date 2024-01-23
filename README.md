# College Management System Microservices

This project consists of microservices for a College Management System. It is designed to manage administrative tasks, staff, students, courses, and student marks. Each service runs independently and communicates with the MySQL database.

# College Management System Microservices
## Microservices Overview

### 1. Dashboard
- ![home](https://github.com/Niranjanc2602/Simple_Collage_management_Microservice_System/assets/112241758/8b099e52-e01b-4b34-bb3a-7c381e750001)
- Description: Provides an overview and navigation for the entire college management system.

### 2. Admin Service
- ![admin home](https://github.com/Niranjanc2602/Simple_Collage_management_Microservice_System/assets/112241758/31a09808-89c1-4cbf-8345-a2d8b827c379)
- ![Admin Login](https://github.com/Niranjanc2602/Simple_Collage_management_Microservice_System/assets/112241758/7eec18d7-7aa6-41aa-a5a6-e528c23e15b2)
- Description: Manages admin-related functionalities.
  
### 3. Staff Service
- ![staff home](https://github.com/Niranjanc2602/Simple_Collage_management_Microservice_System/assets/112241758/4280747a-84ce-4010-8677-c7f421e04394)
- ![staff login](https://github.com/Niranjanc2602/Simple_Collage_management_Microservice_System/assets/112241758/0774bb0d-2938-4766-af05-032f8154e7b2)
- Description: Manages staff-related functionalities.

### 4. Student Service
- ![student login](https://github.com/Niranjanc2602/Simple_Collage_management_Microservice_System/assets/112241758/8eb87fa4-ec33-4f81-bd73-3c8846bd7f4f)
- Description: Manages student-related functionalities.

## MySQL Database Tables

### 1. Admin Table
- Columns:
  - id int
  - name varchar(50)
  - password varchar(50)

### 2. Course Table
- Columns:
  - id int (Primary Key)
  - name varchar(255)

### 3. Marks Table
- Columns:
  - id int (Primary Key)
  - marks int
  - subject varchar(255)
  - staff_id int
  - std_id int

### 4. Staff Table
- Columns:
  - id int (Primary Key)
  - course int
  - mail varchar(255)
  - name varchar(255)
  - password varchar(255)

### 5. Student Table
- Columns:
  - id int (Primary Key)
  - course int
  - mail varchar(255)
  - name varchar(255)
  - password varchar(255)

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/college-management-system.git
   cd college-management-system
   open the project in intellj or eclipse
   run each project
