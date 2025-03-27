package com.formacion.motos.controlador;

import com.formacion.motos.entidades.Cliente;
import com.formacion.motos.servicios.ClienteServicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    private final ClienteServicio clienteServicio;
    
    @Autowired
    Controlador(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

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
	
	    // Guardar en la base de datos
	    clienteServicio.guardarCliente(cliente);
	
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
