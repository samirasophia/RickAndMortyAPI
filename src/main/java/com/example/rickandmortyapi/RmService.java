package com.example.rickandmortyapi;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@SpringBootApplication
@Service
public class RmService {
    private final WebClient webClient;


    public List<RmCharacter> getCharactersByStatus(@RequestParam(value = "status", required = false) String status) {
        if (status != null) {
            return findCharacter().stream()
                    .filter(Rmcharacter -> Rmcharacter.getStatus().equals(status))
                    .collect(Collectors.toList());
        } else {
            return null;
        }}


        public List<RmCharacter> findCharacter () {
            RmResponse response = (webClient
                    .get()
                    .uri("api/character")
                    .retrieve()
                    .toEntity(RmResponse.class)
                    .block()
                    .getBody());
            List<RmCharacter> rmCharacters = new ArrayList<>();
            for (RmResult result : response.results()) {
                rmCharacters.add(new RmCharacter(result.id(), result.name(), result.status())
                );
            }
            System.out.println(response);
            return rmCharacters;


        }

    public List<RmCharacter> getAllCharacters() {
        return null;
    }
}

