package com.example.quizapp.dao;

import com.example.quizapp.model.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ContactDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ContactMessage> getAllContacts() {
        String sql = "SELECT * FROM contact_messages ORDER BY time DESC";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ContactMessage.class));
    }

    // New method to insert a contact message
    public int insertContactMessage(String subject, String email, String message) {
        String sql = "INSERT INTO contact_messages (subject, email, message) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, subject, email, message);
    }
}
