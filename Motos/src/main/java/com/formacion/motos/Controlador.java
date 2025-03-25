package com.formacion.motos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @GetMapping("/")
    public String mostrarLogin() {
        return "login";  // Busca login.jsp en /WEB-INF/views/
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "login"; // Asegúrate de que el nombre coincida con el JSP
    }
}
