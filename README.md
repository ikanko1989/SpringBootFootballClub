# "FootballClub" Spring Boot Application

"Football Club" Spring Boot app to manage football clubs with CRUD operations, connected to:
* AWS RDS MySQL database
* local H2 database
  
3 ways of deployement tested:
* IaC Terraform for deployment to AWS EC2 instance
* CI deployment using GitHub Actions for automated builds and deployment to an AWS EC2 instance
* Locally from InteliJ
  
### What I Learned

Through building this Spring Boot FootballClub application, I gained hands-on experience with developing RESTful APIs using Spring Data JPA and Hibernate. 
Set up continuous deployment using GitHub Actions for automated builds and deployment to an AWS EC2 instance.
I learned how to configure and connect the app to both a local in-memory H2 database for fast testing and an AWS RDS MySQL instance for real-world deployment. I also practiced structuring a Spring Boot project with clean separation of entities, repositories, controllers, and services. The project helped reinforce my understanding of backend development, dependency management with Maven, and API testing using Postman. All development and testing was performed using IntelliJ IDEA.
This repository includes the full source code and configuration files for the FootballClub Spring Boot application, organized as follows. Word doc. includes additional documentation files such as diagrams, screenshots, and detailed descriptions for easier understanding and setup.   
*Notably, screenshots of the AWS RDS MySQL database and AWS EC2 instance creation process are included to guide manual setup in FootballClub SprintBoot project.doc and Spring Boot app via CI.doc .*

## 🚀 Deployment Options

### ✅ 1. **CI Automated Deployment to AWS EC2 via GitHub Actions**
GitHub Actions CI/CD → Builds & SCPs .jar → EC2 instance → EC2 instance → Runs Spring Boot app on port 8080


- Every push to the `main` branch triggers a GitHub Actions workflow
- Maven builds the `.jar` file with `mvn clean package -DskipTests`
- The jar is securely copied to the EC2 instance
- The app is launched remotely via SSH and logs are written to `~/footballclub/app.log`

➡️ Access the app at:  
`http://<EC2_PUBLIC_IP>:8080/`  
(Replace `<EC2_PUBLIC_IP>` with your actual EC2 instance's public IP or DNS)

### ✅ 2. **Manual Local Run via IntelliJ (or any IDE)**
#### a) Using AWS RDS MySQL as the database
#### b) Using H2 In-Memory DB (default)




### Application Architecture
              +---------------------------+
              |     Postman / Client      |
              |  (Sends HTTP requests)    |
              +------------+--------------+
                           |
                           v
              +---------------------------+
              |  Spring Boot REST API     |
              |     (Controller layer)    |
              +------------+--------------+
                           |
                           v
              +---------------------------+
              |    Service Layer (opt.)   |
              | (Business Logic, Optional)|
              +------------+--------------+
                           |
                           v
              +---------------------------+
              |     Repository Layer      |
              |     (Spring Data JPA)     |
              +------------+--------------+
                           |
                           v
              +---------------------------+
              |     Database Access       |
              +------------+--------------+
                           |
           Local H2 Database  (In-memory for testing)
                          or
               AWS RDS MySQL Database (production)

## Features

- CRUD operations for Football Club entities (`id`, `city`, `name`, `yearFounded`)  
- Uses Spring Data JPA and Hibernate ORM  
- Supports local testing with in-memory H2 database  
- Supports production with AWS RDS MySQL database  
- Tested with Postman for API requests  
- Started locally via IntelliJ IDEA  

## Prerequisites

- Java 21+  
- Maven  
- IntelliJ IDEA (recommended for development)  
- AWS account with RDS MySQL instance (optional for production)  
- Postman (for API testing)  

## Configuration

Configure your datasource in `src/main/resources/application.properties`:

```properties
spring.application.name=FootballClub

#H2 Config Default
#spring.datasource.url=jdbc:h2:mem:testdb
#spring.datasource.driver-class-name=org.h2.Driver
#spring.datasource.username=sa
#spring.datasource.password=
#spring.jpa.hibernate.ddl-auto=update
#spring.jpa.show-sql=true
#spring.jpa.properties.hibernate.format_sql=true
#spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#spring.h2.console.enabled=true
#spring.h2.console.path=/h2-console


# AWS RDS MySQL DB
spring.datasource.url=jdbc:mysql://databasetest.czqg6iykc8s2.us-east-1.rds.amazonaws.com:3306/databasetest?useSSL=false&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=Administrator123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect




> **Note:**  
> The MySQL database on AWS RDS must be created manually via the AWS Console before connecting the app. The application will create and update tables automatically via Hibernate when running.

## Running the Application

Start the app locally from IntelliJ IDEA by running the main Spring Boot application class.

The REST API will be available at `http://localhost:8080`.

## Testing

Use Postman (or any REST client) to test the API endpoints for CRUD operations.

- When running locally with H2, data will reset on each restart.  
- When connected to AWS RDS MySQL, data persists between runs.  

## Project Structure

- **entity** — contains JPA entities (each entity corresponds to a table)  
- **repository** — Spring Data JPA repositories  
- **controller** — REST controllers exposing API endpoints  
- **service** — business logic (optional, if used)  

## Dependencies

- Spring Boot Starter Data JPA  
- Spring Boot Starter Web  
- MySQL Connector/J  
- H2 Database (runtime for local tests)  
- Spring Boot Starter Test  
