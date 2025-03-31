package com.formacion.motos.servicios;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
 
@Service
public class ApiService {
 
	
	private final WebClient webClient;
 
    public ApiService(WebClient webClient) {
        this.webClient = webClient;
    }
 
    public String getApiData() {
        String url = "https://dummyjson.com/users/1"; // URL de la API
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block(); // Bloquea para obtener el resultado (no reactivo)
    }
}
