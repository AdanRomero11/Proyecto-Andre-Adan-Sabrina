package com.formacion.motos.controlador.res;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.formacion.motos.servicios.*;
 
@Controller
public class ApiController {
	@Autowired
    private ApiService apiService;
 
    @GetMapping("/api-data")
    public String fetchApiData(Model model) {
    	
    	String apiData = apiService.getApiData();
    	System.out.println(apiData);
        model.addAttribute("apiData", apiData); // Añade los datos al modelo
        return "api"; // Nombre del archivo JSP (sin extensión)
 
    }
 
}
