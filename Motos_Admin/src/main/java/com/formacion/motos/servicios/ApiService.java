package com.formacion.motos.servicios;



import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.formacion.motos.entidades.*;
import com.formacion.motos.repositorio.*;

import lombok.extern.java.Log;


@Service
@Log
public class ApiService {

    private final WebClient webClient;
    private final UsuarioApiRepository UsuarioApiRepository;

    public ApiService(WebClient webClient, UsuarioApiRepository UsuarioApiRepository) {
        this.webClient = webClient;
        this.UsuarioApiRepository = UsuarioApiRepository;
    }

    public List<UsuarioApi> getApiDataList() {
        String url = "https://dummyjson.com/users";
        String response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info("Respuesta JSON: " + response);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UsuarioResponse usersResponse = objectMapper.readValue(response, UsuarioResponse.class);

            // Guardar en la base de datos
            List<UsuarioApi> listaUsuarios = usersResponse.getUsers();
            UsuarioApiRepository.saveAll(listaUsuarios);

            return listaUsuarios;

        } catch (Exception e) {
            throw new RuntimeException("Error al mapear el JSON a UsersResponse.", e);
        }
    }
}
