package com.example.rickandmortyapi;

public record RmCharacter(
        int id,
        String name,
        String status
){
    public Object getStatus() {
        return status;
    }
}
