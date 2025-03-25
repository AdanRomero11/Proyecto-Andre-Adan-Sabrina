package com.formacion.motos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @GetMapping("/")
    public String inicio(Model model) {
        return "login"; // Esto buscará WEB-INF/jsp/login.jsp
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "login";
    }
}
