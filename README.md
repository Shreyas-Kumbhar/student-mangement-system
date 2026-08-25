# Student Management System (stud-man)

A comprehensive Student Management System built with **Spring Boot 3**, **Java 21**, **Spring Data JPA**, and **Thymeleaf**. This application provides a complete CRUD (Create, Read, Update, Delete) interface for managing student records.

## Features

- **Add New Students**: Form with validation for creating new student profiles.
- **View All Students**: A list view to display all registered students.
- **Update Student Records**: Edit existing student details.
- **Delete Students**: Remove individual students or delete all records at once.
- **Form Validation**: Backend validation ensuring data integrity (e.g., valid email, password length, 10-digit phone number).
- **Responsive UI**: Frontend pages rendered using Thymeleaf templates.

## Technology Stack

- **Backend**: Java 21, Spring Boot 3.2.5
- **Database**: MySQL (Runtime) / H2 (Testing)
- **ORM**: Spring Data JPA / Hibernate
- **Template Engine**: Thymeleaf
- **Build Tool**: Maven
- **Utilities**: Lombok (for reducing boilerplate code), Spring Boot Validation

## Project Structure

- `com.model.Student`: The JPA Entity representing a student with fields like `id`, `name`, `email`, `password`, `phone`, and `address`. Includes validation annotations.
- `com.repository.StudentRepository`: Spring Data JPA repository for database operations.
- `com.service.StudentService`: Service layer containing business logic.
- `com.controller.StudentController`: Spring MVC Controller handling web requests and routing.
- `src/main/resources/templates/`: Thymeleaf HTML templates (`form.html`, `students.html`, `update.html`, `success.html`).

## Prerequisites

- **Java 21** or higher
- **Maven** 3.6+
- **MySQL Server** running locally (or adjust the `application.properties` to use H2)

## Setup & Configuration

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd stud-man
   ```

2. **Configure Database:**
   Ensure MySQL is running. The application expects a database named `student_db`. If it doesn't exist, create it:
   ```sql
   CREATE DATABASE student_db;
   ```
   Check `src/main/resources/application.properties` and update the database credentials if necessary:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/student_db
   spring.datasource.username=root
   spring.datasource.password=Shreyas@123
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints / Routes

| HTTP Method | Endpoint | Description |
|---|---|---|
| GET | `/students/list` | Displays the list of all students |
| GET | `/students/add` | Displays the form to add a new student |
| POST | `/students` | Saves a new student to the database |
| GET | `/students/update/{id}` | Displays the form to update an existing student |
| POST | `/students/update/{id}` | Submits the updated student data |
| POST | `/students/delete/{id}` | Deletes a specific student |
| POST | `/students/delete/all` | Deletes all students from the database |

## Validation Constraints

The `Student` model enforces the following constraints:
- **Name**: Cannot be empty.
- **Email**: Must be a valid email format.
- **Password**: Cannot be blank, minimum 6 characters.
- **Phone**: Must be exactly 10 digits.
- **Address**: Cannot be empty.

## License
This project is open-source. Feel free to use and modify it as per your requirements.
