# MessageMingle - One-to-One Chat Application

## Overview

MessageMingle is a one-to-one chat application built using Java, Spring Boot, WebSockets, MySQL, Docker for the backend, and HTML, CSS, and JavaScript for the frontend. This application allows users to engage in private conversations with each other in real-time.

## Features

- **Real-Time Messaging:** Utilizing WebSockets for instant communication between users.
- **User Authentication:** Secure user authentication to ensure private conversations.
- **Persistent Storage:** Messages are stored in a MySQL database, providing persistence across sessions.
- **Docker Support:** Easily deploy and run the application in a Docker container.

## Technologies Used

- **Backend:**
  - Java
  - Spring Boot
  - WebSockets
  - MySQL

- **Frontend:**
  - HTML
  - CSS
  - JavaScript

- **Deployment:**
  - Docker

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK)
- Docker
- MySQL
- (Any additional dependencies)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/MessageMingle.git
   ```

2. Navigate to the project directory:

   ```bash
   cd MessageMingle
   ```

3. (Add any additional setup steps here)

## Configuration

Configure the application by updating the `application.properties` file with your database credentials, or any other necessary configurations.

## Running the Application

Follow these steps to run the MessageMingle application:

1. Build the project:

   ```bash
   .mvn spring-boot:run
   ```

2. Access the application at [http://localhost:8080](http://localhost:8080)

## Docker Deployment

To deploy the application using Docker, follow these steps:

1. Build the Docker image:

   ```bash
   docker build -t messagemingle-app .
   ```

2. Run the Docker container:

   ```bash
   docker run -p 8080:8080 messagemingle-app
   ```

3. Access the application at [http://localhost:8080](http://localhost:8080)
