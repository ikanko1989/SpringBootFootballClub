# Description
Spring Boot App Deployment on AWS EC2 via Terraform.   
This project demonstrates the automated deployment of a Java Spring Boot application on an AWS EC2 instance using Terraform infrastructure-as-code. By leveraging Terraform, the entire AWS environment setup—including EC2 instance provisioning, security group configuration, and application deployment—is automated, enabling repeatable and efficient deployments.

The Spring Boot application itself is a simple yet functional web service for managing football clubs, showcasing typical CRUD operations backed by an embedded database.

# What this project does
Infrastructure automation:  
Uses Terraform scripts to provision AWS EC2 instances, configure security groups, and prepare the environment.

Application deployment:   
Automatically installs Java and Maven on the EC2 instance, builds the Spring Boot app, and starts the application.

Infrastructure as Code (IaC):   
Allows you to version, maintain, and share your cloud infrastructure alongside your code.

Rapid testing and exposure:   
Quickly spin up or tear down the app environment for development, testing, or demonstration purposes.

# Workflow:

**1. Create an AWS EC2 instance with Terraform**

**2. Use user_data to:**

***Install Java**

***Install Git**

***Clone my Spring Boot app from GitHub**

**3. Build & run it on port 8080**

**4. Allow HTTP/8080 traffic**

**5. Access my app at: http://EC2-PUBLIC-IP:8080**
