package com.example.rickandmortyapi;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor
public class Controller {
    final RmService service;
    @GetMapping("/all")
    List<RmCharacter> findCharacter(){
        return service.findCharacter();
    }
    @GetMapping
    public List<RmCharacter> getCharactersByStatus(@RequestParam(value = "status", required = false) String status) {
        if (status != null) {
            return service.getCharactersByStatus(status);
        } else {
            return service.getAllCharacters();
        }
}}

