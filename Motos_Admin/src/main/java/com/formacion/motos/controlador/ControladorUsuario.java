package com.formacion.motos.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.extern.java.Log;

@Controller
@RequestMapping("/usuario")
@Log
public class ControladorUsuario {
	
	
	@PostMapping("/updateUsuario")
	public ResponseEntity<String> updateUsuario(@RequestParam int id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String image) {


		log.info("Llegan " + id + " : " + firstName);
		// Devuelve una respuesta de éxito
        return ResponseEntity.ok("Actualizado correctamente.");

	}
	

}
