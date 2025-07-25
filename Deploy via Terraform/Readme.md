# Description
Spring Boot App Deployment on AWS EC2 via Terraform.   
This project uses Terraform to automate the deployment of a Java Spring Boot application on an AWS EC2 instance.   
When applied:  
This setup enables quick testing and exposure of Spring Boot app using infrastructure-as-code.


# Workflow:

**1. Create an AWS EC2 instance with Terraform**

**2. Use user_data to:**

***Install Java**

***Install Git**

***Clone my Spring Boot app from GitHub**

**3. Build & run it on port 8080**

**4. Allow HTTP/8080 traffic**

**5. Access my app at: http://EC2-PUBLIC-IP:8080**
