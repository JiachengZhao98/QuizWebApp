package com.example.quizapp.service;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuestionDAO questionDAO;

    // Fetch random questions for the given category.
    public List<Question> getQuizQuestions(int categoryId, int numberOfQuestions) {
        return questionDAO.getRandomQuestionsByCategory(categoryId, numberOfQuestions);
    }
}
