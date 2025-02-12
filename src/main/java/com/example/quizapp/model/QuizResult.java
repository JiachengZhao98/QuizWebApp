package com.example.quizapp.model;

import java.time.LocalDateTime;

public class QuizResult {
    private int id;
    private int userId;
    private String userFullName;
    private String category;
    private LocalDateTime takenTime;
    private int numQuestions;
    private int score;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getUserFullName() { return userFullName; }
    public void setUserFullName(String userFullName) { this.userFullName = userFullName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDateTime getTakenTime() { return takenTime; }
    public void setTakenTime(LocalDateTime takenTime) { this.takenTime = takenTime; }

    public int getNumQuestions() { return numQuestions; }
    public void setNumQuestions(int numQuestions) { this.numQuestions = numQuestions; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
