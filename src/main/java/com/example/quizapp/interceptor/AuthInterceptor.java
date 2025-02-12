package com.example.quizapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        // Allow access to public pages (login, register, contact, etc.)
        String uri = request.getRequestURI();
        if (user == null) {
            if (uri.contains("/login") || uri.contains("/register") ||
                    uri.contains("/contact") || uri.contains("/contactSubmit")) {
                return true;
            }
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }

}
