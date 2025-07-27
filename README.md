# "FootballClub" Java Spring Boot Application

"Football Club" is Java Spring Boot app to manage football clubs with CRUD operations, connected to:
* AWS RDS MySQL database
* local H2 database  

  
✅ Deployment Methods Used 

This project has been successfully deployed using the following methods:

1. **Infrastructure as Code (IaC)** using **Terraform** to provision and deploy to an AWS EC2 instance
2. **Continuous Integration (CI)** with **GitHub Actions** for automated build and deployment to AWS EC2
3. **Local execution** from **IntelliJ IDEA** during development and testing


### What I Learned

While building the FootballClub Spring Boot application, I gained valuable hands-on experience with:

* Building **RESTful APIs** using Spring Boot, Spring Data JPA, and Hibernate
* Connecting to both **local H2** and **AWS RDS MySQ**L databases
* Structuring clean and maintainable code with layers: Entities → Repositories → Services → Controllers
* Dependency management using **Maven**
* API testing using **Postman**
* Local development and testing with **IntelliJ IDEA**
* Implementing **CI/CD** with **GitHub Actions** for automated deployments
* Using **Terraform** to automate cloud infrastructure provisioning on **AWS**

_Notably, this repository includes manual setup guides named:_
* _FootballClub SpringBoot project.doc_
* _Spring Boot app via CI.doc_
* _SpringBootApp deploy via Terraform.doc_
  
...with detailed configuration descriptions,screenshots of AWS RDS MySQL, EC2 instance creation, GitHub Actions workflow runs,Terraform etc.  


✅**Technologies Used**
* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL (via AWS RDS)
* H2 (for local development)
* Maven (for build and dependency management)
* GitHub Actions (for CI/CD pipeline)
* Terraform (for infrastructure provisioning on AWS)
* AWS EC2 (to host the application)
* Postman (for API testing)
* IntelliJ IDEA (for development)

  
## Deployment Options

### ✅ 1. **IaC Deployment to AWS EC2 via Terraform**
Terraform → Provisions EC2 instance → Clones GitHub repo → Runs Spring Boot app on port 8080

- Terraform is used to define and provision the AWS EC2 instance as Infrastructure as Code
- The EC2 instance is configured to install Java ,Git and Maven during setup via user data script
- On startup, the instance clones this GitHub repository
- The Spring Boot application is built and run automatically

➡️ Accessed the app at:  
`http://<EC2_PUBLIC_IP>:8080/`  
(Replaced `<EC2_PUBLIC_IP>` with your actual EC2 instance's public IP or DNS)



### ✅ 2. **CI Automated Deployment to AWS EC2 via GitHub Actions**
GitHub Actions CI/CD → Builds & SCPs .jar → EC2 instance → EC2 instance → Runs Spring Boot app on port 8080

- Every push to the `main` branch triggers a GitHub Actions workflow
- Maven builds the `.jar` file with `mvn clean package -DskipTests`
- The jar is securely copied to the EC2 instance
- The app is launched remotely via SSH and logs are written to `~/footballclub/app.log`

➡️ Accessed the app at:  
`http://<EC2_PUBLIC_IP>:8080/`  
(Replaced `<EC2_PUBLIC_IP>` with your actual EC2 instance's public IP or DNS)

### ✅ 3. **Manual Local Run via IntelliJ (or any IDE)**
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
spring.datasource.username=xxxx
spring.datasource.password=xxxxxxxxxxxx
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
