package com.formacion.motos.servicios;

import java.util.List;
import org.springframework.stereotype.Service;

import com.formacion.motos.entidades.Cliente;
import com.formacion.motos.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio {
	
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
    	
        this.clienteRepositorio = clienteRepositorio;
        
    }

    public Cliente encontrarPorNombre(String nombre) {
    	
        return clienteRepositorio.findByNombre(nombre);
        
    }

    public Cliente guardarCliente(Cliente cliente) {
    	
        return clienteRepositorio.save(cliente);
        
    }
    
    public List<Cliente> findAllUsers() {
    	
        return clienteRepositorio.findAll();
        
    }
    
}
