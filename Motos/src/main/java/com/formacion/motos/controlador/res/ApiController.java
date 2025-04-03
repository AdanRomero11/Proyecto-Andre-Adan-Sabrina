package com.formacion.motos.controlador.res;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.formacion.motos.entidades.User;
import com.formacion.motos.servicios.UserService;

@Controller
public class ApiController {

    private final UserService userService;

    public ApiController(UserService userService) {
        this.userService = userService;
    }

    // Cargar la página con el botón
    @GetMapping("/api-data")
    public String api(Model model) {
    	List<User> usuarios = userService.obtenerTodosLosUsuarios(); // Método que consulta la BD
        model.addAttribute("lista", usuarios);
        return "api"; // Carga la vista `api.jsp`
    }
    
    @PostMapping("/usuario/updateUsuario")
    public ResponseEntity<String> actualizarUsuario(@RequestBody User user) {  
        try {
            userService.updateUser(user);
            return ResponseEntity.ok("Usuario actualizado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar usuario: " + e.getMessage());
        }
    }


    // Ejecutar la carga de datos cuando se presione el botón
    @PostMapping("/fetch-users")
    public String fetchUsers(Model model) {
        userService.fetchAndStoreUsers();
        model.addAttribute("message", "Datos obtenidos correctamente!");
        return "api"; // Retorna a la vista después de obtener los datos
    }
}
