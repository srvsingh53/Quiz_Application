# Quiz App - Spring Boot

This is a simple quiz app implemented in Spring Boot with H2 Database. The app provides APIs for starting a quiz session, fetching random questions, submitting answers, and getting results.

## Features:
- Start a new quiz session.
- Get a random multiple-choice question.
- Submit answers and get the result.
- Get the total questions answered with correct and incorrect submissions.

## Assumptions:
- The app uses H2 Database for simplicity.
- Some questions and a default user are seeded in the database.

## How to Run:

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/quiz-app-springboot.git
   ```

2. Navigate into the project directory:
   ```bash
   cd quiz-app-springboot
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. The app will run on `http://localhost:8080`.

## Endpoints:
- **POST** `/api/quiz/start`: Start a new quiz session.
- **GET** `/api/quiz/question`: Get a random multiple-choice question.
- **POST** `/api/quiz/submit`: Submit an answer.
- **GET** `/api/quiz/results`: Get the total questions answered with correct/incorrect details.

## Database:
- H2 Database is used for simplicity and is pre-populated with some questions.
- The database can be accessed at `http://localhost:8080/h2-console` for testing.
- Username: `sa`
- Password: `password`
- JDBC URL: `jdbc:h2:mem:testdb`
