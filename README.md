# Grade Book System

The development is not complete yet.

### 1. API Definitions

Example: Allocations

  - **[GET]/allocations** - Get list of allocations
  - **[GET]/allocations/{allocationId}** - Get allocation by ID
  - **[POST]/allocations (JSON Body)** - Add new entry in Allocations
  - **[PUT]/allocations/{allocationId} (JSON Body)**  - Add new entry in Allocations
  - **[DELETE]/allocations/{allocationId}**  - Add new entry in Allocations
  
---

### 2. Code Logic

  **Design Patterns** - Used Factory Pattern for Assessments (service package)
  
  **Spring Boot features**
  
  - Annotation Configurations
  - Autowiring
  - Controllers
  - Rest APIs
  - Embedded Tomcat
  
  ---
  
 ### 3. TDD
 
 Followd TDD approach
 
   - Added test cases for +ve and -ve scenarios

---

 ### 4. Build Tool
 
 Used maven as build tool
 
   ```sh
   mvn clean package
   ```
---

 ### 5. Docker Configuration
 
 Added Dockerfile for reference
 
 Run below scripts to create image and push to registry
 
 
   ```sh
   docker pull openjdk
   docker image build -t grade-book:latest .
   docker container run -d -p 8080:8080 grade-book:latest
   ```


   ```sh
   docker login <registry>
   docker tag grade-book <registry>/grade-book
   docker push <registry>/grade-book
   ```