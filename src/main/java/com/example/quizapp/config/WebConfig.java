package com.example.quizapp.config;

import com.example.quizapp.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .excludePathPatterns("/login", "/register", "/contact", "/contactSubmit", "/css/**", "/js/**", "/images/**");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Redirect the root URL to the login page.
        registry.addViewController("/").setViewName("redirect:/login");
    }
}
