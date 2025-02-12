package com.example.quizapp.dao;

import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // This method returns a list of random questions for a specific category.
    public List<Question> getRandomQuestionsByCategory(int categoryId, int limit) {
        String sql = "SELECT * FROM questions WHERE category_id = ? ORDER BY RAND() LIMIT ?";
        return jdbcTemplate.query(sql, new Object[]{categoryId, limit},
                new BeanPropertyRowMapper<>(Question.class));
    }

    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM questions";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Question.class));
    }

    public Question getQuestionById(int id) {
        String sql = "SELECT * FROM questions WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Question.class));
    }

    public int updateQuestionStatus(int questionId, String status) {
        String sql = "UPDATE questions SET status = ? WHERE id = ?";
        return jdbcTemplate.update(sql, status, questionId);
    }

    public int updateQuestion(Question question) {
        String sql = "UPDATE questions SET category_id = ?, question_text = ?, option_a = ?, option_b = ?, option_c = ?, option_d = ?, correct_option = ? WHERE id = ?";
        return jdbcTemplate.update(sql, question.getCategoryId(), question.getQuestionText(), question.getOptionA(), question.getOptionB(), question.getOptionC(), question.getOptionD(), question.getCorrectOption(), question.getId());
    }

    public int addQuestion(Question question) {
        String sql = "INSERT INTO questions (category_id, question_text, option_a, option_b, option_c, option_d, correct_option, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, question.getCategoryId(), question.getQuestionText(), question.getOptionA(), question.getOptionB(), question.getOptionC(), question.getOptionD(), question.getCorrectOption(), "active");
    }

}
