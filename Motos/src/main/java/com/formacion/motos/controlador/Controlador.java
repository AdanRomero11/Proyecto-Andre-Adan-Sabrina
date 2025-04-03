package com.formacion.motos.controlador;

import com.formacion.motos.entidades.Cliente;
import com.formacion.motos.repositorio.ClienteRepositorio;
import com.formacion.motos.servicios.ClienteServicio;

import jakarta.servlet.http.HttpServletRequest;

import com.formacion.motos.config.SecurityConfig;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    private final PasswordEncoder passwordEncoder;

    private final ClienteServicio clienteServicio;
    
    @Autowired
    Controlador(ClienteServicio clienteServicio, PasswordEncoder passwordEncoder) {
        this.clienteServicio = clienteServicio;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String inicio(Model model) {
    	
        return "login"; // Esto buscará WEB-INF/jsp/login.jsp
        
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, 
                        @RequestParam String password, 
                        Model model) {
        
        System.out.println("Intentando loguear con email: " + email);

        if (clienteServicio.verifyUserCredentials(email, password)) {
        	
            Cliente cliente = clienteServicio.encontrarPorEmail(email);
            
            System.out.println("Cliente encontrado: " + cliente.getNombre());  // Asegúrate de que se imprima correctamente
            
            model.addAttribute("nombreCliente", cliente.getNombre());
            return "principal";
            
        } else {
        	
	        System.out.println("Falló la autenticación. Volviendo a login.jsp");
        
	        model.addAttribute("error", "Email o contraseña incorrectos");
	        return "login"; // Vuelve a la pantalla de login si las credenciales son incorrectas
	        
        }  

    }

    @GetMapping("/logout")
    public String cerrarSesion() {

        return "redirect:/"; // Redirige a la página de login (la de inicio)
    }
    
    @GetMapping("/registro")
    public String mostrarRegistro() {
    	
        return "registro";
        
    }
    
	@PostMapping("/crearCliente")
	public String procesarRegistro(
	        @RequestParam String nombre,
	        @RequestParam String apellido1,
	        @RequestParam(required = false) String apellido2,
	        @RequestParam String calle,
	        @RequestParam int numero,
	        @RequestParam String codigoP,
	        @RequestParam String localidad,
	        @RequestParam String poblacion,
	        @RequestParam String telefono,
	        @RequestParam String email,
	        @RequestParam String password,
	        Model model) {
	
	    Cliente cliente = new Cliente();
	    cliente.setNombre(nombre);
	    cliente.setApellido1(apellido1);
	    if (apellido2 != null) cliente.setApellido2(apellido2);
	    cliente.setCalle(calle);
	    cliente.setNumero(numero);
	    cliente.setCodigoP(codigoP);
	    cliente.setLocalidad(localidad);
	    cliente.setPoblacion(poblacion);
	    cliente.setTelefono(telefono);
	    cliente.setEmail(email);
        cliente.setPassword(password);
	    
        // Establecer la fecha de registro al momento actual
        cliente.setFechaRegistro(new Date());
	
        try {
            
            clienteServicio.guardarCliente(cliente);
            model.addAttribute("mensaje", "Usuario registrado con éxito: " + nombre);
            return "registro";
            
        } catch (DataIntegrityViolationException e) {

            model.addAttribute("mensajeError", "Error al registrar el usuario. Puede que el correo ya esté en uso.");
            return "registro";
            
        } catch (Exception e) {
        	
            model.addAttribute("mensajeError", "Ha ocurrido un error inesperado. Intenta de nuevo.");
            return "registro";
        }
	}

    
    
}
