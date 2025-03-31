package com.formacion.motos.servicios;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.formacion.motos.entidades.Cliente;
import com.formacion.motos.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio {

    private final PasswordEncoder passwordEncoder;
	
    private final ClienteRepositorio clienteRepositorio;


    public ClienteServicio(ClienteRepositorio clienteRepositorio, PasswordEncoder passwordEncoder) {
    	
        this.clienteRepositorio = clienteRepositorio;
    	
        this.passwordEncoder = passwordEncoder;
        
    }

    public Cliente encontrarPorEmail(String email) {
    	
        return clienteRepositorio.findByEmail(email);
        
    }
    
    public Cliente guardarCliente(Cliente cliente) {
    	
    	cliente.setPassword(passwordEncoder.encode(cliente.getPassword())); // Encriptar contraseña
    	
        return clienteRepositorio.save(cliente);
        
    }
    
    public List<Cliente> findAllUsers() {
    	
        return clienteRepositorio.findAll();
        
    }
    
    public Long contarUsuarios() {
    	return clienteRepositorio.count();
    }
    
    // Nuevo método para verificar credenciales
    
    public boolean verifyUserCredentials(String email, String rawPassword) {
    	
        Cliente cliente = clienteRepositorio.findByEmail(email);
          
        if (cliente != null) {
            
            // Compara la contraseña ingresada con la encriptada almacenada
            return passwordEncoder.matches(rawPassword, cliente.getPassword());
            
        }
        return false;
    }
    
}
