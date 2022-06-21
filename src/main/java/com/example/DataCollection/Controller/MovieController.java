package com.example.DataCollection.Controller;

import com.example.DataCollection.Service.MovieServiceImpl;
import lombok.Data;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fill")
@Data
public class MovieController {
    final MovieServiceImpl movieService;



    @GetMapping("/get-now-playing")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }
}
