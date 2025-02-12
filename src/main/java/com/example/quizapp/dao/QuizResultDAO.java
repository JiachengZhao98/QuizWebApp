package com.example.quizapp.dao;

import com.example.quizapp.model.QuizResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class QuizResultDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Optionally filter by category and/or user (full name)
    public List<QuizResult> getAllQuizResults(String category, String user) {
        String sql = "SELECT * FROM quiz_results WHERE 1=1";
        if (category != null && !category.isEmpty()) {
            sql += " AND category = '" + category + "'";
        }
        if (user != null && !user.isEmpty()) {
            sql += " AND user_full_name LIKE '%" + user + "%'";
        }
        sql += " ORDER BY taken_time DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(QuizResult.class));
    }

    public QuizResult getQuizResultById(int id) {
        String sql = "SELECT * FROM quiz_results WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(QuizResult.class));
    }

    // Retrieve quiz results for a specific user, sorted by most recent first.
    public List<QuizResult> getQuizResultsByUserId(int userId) {
        String sql = "SELECT id, userId AS userId, userFullName AS userFullName, category, takenTime AS takenTime, numQuestions AS numQuestions, score " +
                "FROM quiz_results " +
                "WHERE userId = ? " +
                "ORDER BY takenTime DESC";
        return jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(QuizResult.class));
    }

    public int insertQuizResult(QuizResult quizResult) {
        String sql = "INSERT INTO quiz_results (userId, userFullName, category, takenTime, numQuestions, score) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                quizResult.getUserId(),
                quizResult.getUserFullName(),
                quizResult.getCategory(),
                quizResult.getTakenTime(),
                quizResult.getNumQuestions(),
                quizResult.getScore());
    }
}
