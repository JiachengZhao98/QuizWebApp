package com.example.quizapp.controller;

import com.example.quizapp.dao.QuizResultDAO;
import com.example.quizapp.model.QuizResult;
import com.example.quizapp.model.User;
import com.example.quizapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizResultDAO quizResultDAO;

    // Display login page (default)
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Process login
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        User user = userService.authenticate(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }

    // Display registration page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Process registration
    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           Model model) {
        boolean success = userService.registerUser(user);
        if (success) {
            model.addAttribute("message", "Registration successful. Please login.");
            return "login";
        } else {
            model.addAttribute("error", "Email already exists.");
            return "register";
        }
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        // Retrieve the logged-in user from the session.
        User user = (User) session.getAttribute("user");
        if (user == null) {
            // Redirect to login if not logged in.
            return "redirect:/login";
        }

        // Get the user's quiz results.

        List<QuizResult> quizResults = quizResultDAO.getQuizResultsByUserId(user.getId());

        // Add the results to the model. (It will be empty if the user hasn't taken any quizzes.)
        model.addAttribute("quizResults", quizResults);

        return "home"; // This resolves to src/main/webapp/WEB-INF/views/home.jsp
    }
}
