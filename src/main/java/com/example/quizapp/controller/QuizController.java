package com.example.quizapp.controller;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.dao.QuizResultDAO;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.QuizResult;
import com.example.quizapp.model.User;
import com.example.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private QuizResultDAO quizResultDAO;
    @Autowired
    private QuizService quizService;

    @GetMapping("/quiz/{categoryId}")
    public String showQuiz(@PathVariable("categoryId") int categoryId,
                           @RequestParam(value = "num", defaultValue = "5") int numQuestions,
                           Model model,
                           HttpSession session) {
        session.setAttribute("quizStartTime", LocalDateTime.now());
        List<Question> questions = quizService.getQuizQuestions(categoryId, numQuestions);
        model.addAttribute("questions", questions);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("quizName", "Quiz for Category " + categoryId);
        return "quiz"; // Resolves to quiz.jsp
    }

    @PostMapping("/submitQuiz")
    public String submitQuiz(@RequestParam("categoryId") int categoryId,
                             @RequestParam MultiValueMap<String, String> formData,
                             Model model,
                             HttpSession session) {
        LocalDateTime startTime = (LocalDateTime) session.getAttribute("quizStartTime");
        LocalDateTime endTime = LocalDateTime.now();
        User user = (User) session.getAttribute("user");

        int correctCount = 0;
        // This map will hold details for each question to display on the result page.
        Map<String, Map<String, String>> questionResults = new HashMap<>();

        // Process each answer submitted.
        for (Map.Entry<String, List<String>> entry : formData.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("q")) {
                // Extract question ID from the key (e.g., "q5" => 5)
                int questionId = Integer.parseInt(key.substring(1));
                String userAnswer = entry.getValue().get(0);

                // Retrieve the corresponding question from the database.
                Question question = questionDAO.getQuestionById(questionId);
                String correctAnswer = question.getCorrectOption();

                // Evaluate the answer.
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    correctCount++;
                }

                // Prepare details for this question.
                Map<String, String> details = new HashMap<>();
                details.put("questionText", question.getQuestionText());
                details.put("optionA", question.getOptionA());
                details.put("optionB", question.getOptionB());
                details.put("optionC", question.getOptionC());
                details.put("optionD", question.getOptionD());
                details.put("userAnswer", userAnswer);
                details.put("correctAnswer", correctAnswer);
                questionResults.put(key, details);
            }
        }

        // Create and insert a QuizResult record into the database.
        QuizResult quizResult = new QuizResult();
        quizResult.setUserId(user.getId());
        quizResult.setUserFullName(user.getFirstName() + " " + user.getLastName());
        quizResult.setCategory("Category " + categoryId); // Adjust if you have a category name
        quizResult.setTakenTime(endTime);
        quizResult.setNumQuestions(questionResults.size());
        quizResult.setScore(correctCount);

        quizResultDAO.insertQuizResult(quizResult);

        // Add attributes for display.
        model.addAttribute("quizName", "Quiz for Category " + categoryId);
        model.addAttribute("userFullName", user.getFirstName() + " " + user.getLastName());
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("correctCount", correctCount);
        model.addAttribute("totalQuestions", questionResults.size());
        model.addAttribute("questionResults", questionResults);

        return "result";  // Maps to result.jsp
    }


}
