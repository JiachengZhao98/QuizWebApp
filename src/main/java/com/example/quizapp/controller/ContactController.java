package com.example.quizapp.controller;

import com.example.quizapp.dao.ContactDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactDAO contactDAO;

    // Display the Contact Us page.
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    // Process contact form submissions.
    @PostMapping("/contactSubmit")
    public String submitContact(@RequestParam("subject") String subject,
                                @RequestParam("email") String email,
                                @RequestParam("message") String message,
                                Model model) {
        int result = contactDAO.insertContactMessage(subject, email, message);
        if(result > 0){
            model.addAttribute("msg", "Your message has been sent successfully!");
        } else {
            model.addAttribute("msg", "There was an error sending your message. Please try again.");
        }
        return "contact";
    }
}
