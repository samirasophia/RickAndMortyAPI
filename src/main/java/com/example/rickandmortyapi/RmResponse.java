package com.example.rickandmortyapi;

import java.util.List;

public record RmResponse(int total_count, List<RmResult> results){
}

