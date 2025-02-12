# Quiz Web Application

A Quiz Web Application built using Spring Boot, Spring MVC, JDBC Template (without ORM), MySQL, JSP, and JSTL. This project enables users to register, log in, take quizzes with random questions from multiple categories, view their quiz results, and send messages via a Contact Us page. An admin section is also provided to manage users, quiz results, questions, and contact messages.

## Technologies

- Java 11
- Spring Boot & Spring MVC
- JDBC Template (no Hibernate)
- MySQL
- JSP & JSTL
- Maven

## Setup Instructions

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/JiachengZhao98/QuizWebApp.git
   cd quiz-app
   ```

2. **Database Setup:**

    - Create a MySQL database named `quizdb`:

      ```sql
      CREATE DATABASE IF NOT EXISTS quizdb;
      USE quizdb;
      ```

    - Run the provided SQL scripts (or create tables manually) for:
        - `users`
        - `questions`
        - `quiz_results`
        - `contact_messages`

3. **Configure Application Properties:**

   Edit `src/main/resources/application.properties` with your database details:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/quizdb?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=zjcZJC924\$
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.mvc.view.prefix=/WEB-INF/views/
   spring.mvc.view.suffix=.jsp
   ```

4. **Build and Run:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## Usage

- **User Section:**
    - Register and log in at `/login`.
    - On the home page, choose a quiz category (e.g., General Knowledge, Science, History) to take a quiz with 5 random questions.
    - View quiz results (score, correct answers) after submission.
    - Use the Contact Us page to send messages.

- **Admin Section:**
    - Access admin features at `/admin/home` to manage users, quiz results, questions, and contact messages.

## License

This project is licensed under the MIT License.