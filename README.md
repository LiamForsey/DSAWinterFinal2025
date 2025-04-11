Binary Search Tree Generator
Overview
A Spring Boot application that builds and visualizes binary search trees from user input. Users can:

Create standard or balanced BSTs

View previous tree generations

Access results via web interface or API

Requirements
Java 17+

Maven 3.6+

Internet connection (for dependencies)

Installation
Clone the repository

Build the project:

bash
Copy
mvn clean install
Running the Application
bash
Copy
mvn spring-boot:run
Accessing the Application
You must manually enter these URLs in your browser:

Page	URL
Home	http://localhost:8080/
Create BST	http://localhost:8080/enter-numbers
View History	http://localhost:8080/previous-trees
API Endpoints
Copy
POST /api/process-numbers?numbers=5,3,7
POST /api/balanced-tree?numbers=5,3,7
GET /api/previous-trees
Key Features
Interactive web interface

Persistent storage of tree history

Both standard and balanced BST generation

Text and formatted tree visualization

Troubleshooting
If pages don't load:

Verify application is running (Started BinarySearchTreeApplication)

Check for typos in manually entered URLs

Clear browser cache (Ctrl+F5)

Notes
The application must be accessed through http://localhost:8080

Do not open HTML files directly - they won't work outside Spring Boot
