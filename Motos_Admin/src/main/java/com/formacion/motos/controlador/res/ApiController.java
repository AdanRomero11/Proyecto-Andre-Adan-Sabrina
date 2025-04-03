package com.formacion.motos.controlador.res;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacion.motos.controlador.res.ApiController;
import com.formacion.motos.servicios.*;
import com.formacion.motos.entidades.*;


import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
    private ApiService apiService;

	@GetMapping("/data")
	public String fetchApiData(Model model) {
		
	    List<UsuarioApi> lista = apiService.getApiDataList();
	    model.addAttribute("lista", lista); // Envía la lista a la vista
	    return "api";
	    
	}
	
	@GetMapping
	public String redirigirApi() {
		
	    return "redirect:/api";
	    
	}
}
