package com.example.quizapp.controller;

import com.example.quizapp.dao.UserDAO;
import com.example.quizapp.dao.QuizResultDAO;
import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.dao.ContactDAO;
import com.example.quizapp.model.User;
import com.example.quizapp.model.QuizResult;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.ContactMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private QuizResultDAO quizResultDAO;

    @Autowired
    private QuestionDAO questionDAO;

    @Autowired
    private ContactDAO contactDAO;

    // Admin Home Page
    @GetMapping("/home")
    public String adminHome() {
        return "admin/home";
    }

    // --------------------
    // User Management Page
    // --------------------
    @GetMapping("/users")
    public String userManagement(Model model) {
        List<User> users = userDAO.getAllUsers();
        model.addAttribute("users", users);
        return "admin/userManagement";
    }

    @PostMapping("/users/updateStatus")
    public String updateUserStatus(@RequestParam("userId") int userId,
                                   @RequestParam("status") String status) {
        userDAO.updateUserStatus(userId, status);
        return "redirect:/admin/users";
    }

    // ---------------------------
    // Quiz Result Management Page
    // ---------------------------
    @GetMapping("/quizResults")
    public String quizResultManagement(@RequestParam(value="category", required=false) String category,
                                       @RequestParam(value="user", required=false) String user,
                                       Model model) {
        List<QuizResult> results = quizResultDAO.getAllQuizResults(category, user);
        model.addAttribute("results", results);
        return "admin/quizResultManagement";
    }

    @GetMapping("/quizResult/{id}")
    public String quizResultDetail(@PathVariable("id") int id, Model model) {
        QuizResult result = quizResultDAO.getQuizResultById(id);
        model.addAttribute("result", result);
        return "admin/quizResultDetail";
    }

    // ---------------------------
    // Question Management Section
    // ---------------------------
    @GetMapping("/questions")
    public String questionManagement(Model model) {
        List<Question> questions = questionDAO.getAllQuestions();
        model.addAttribute("questions", questions);
        return "admin/questionManagement";
    }

    @PostMapping("/questions/updateStatus")
    public String updateQuestionStatus(@RequestParam("questionId") int questionId,
                                       @RequestParam("status") String status) {
        questionDAO.updateQuestionStatus(questionId, status);
        return "redirect:/admin/questions";
    }

    @GetMapping("/question/edit/{id}")
    public String editQuestionPage(@PathVariable("id") int id, Model model) {
        Question question = questionDAO.getQuestionById(id);
        model.addAttribute("question", question);
        return "admin/questionEdit";
    }

    @PostMapping("/question/edit")
    public String editQuestion(@ModelAttribute Question question) {
        questionDAO.updateQuestion(question);
        return "redirect:/admin/questions";
    }

    @GetMapping("/question/add")
    public String addQuestionPage(Model model) {
        model.addAttribute("question", new Question());
        return "admin/questionAdd";
    }

    @PostMapping("/question/add")
    public String addQuestion(@ModelAttribute Question question) {
        questionDAO.addQuestion(question);
        return "redirect:/admin/questions";
    }

    // -----------------------------
    // Contact Us Management Section
    // -----------------------------
    @GetMapping("/contacts")
    public String contactManagement(Model model) {
        List<ContactMessage> contacts = contactDAO.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "admin/contactManagement";
    }
}
