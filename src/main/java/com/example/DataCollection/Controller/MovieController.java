package com.example.DataCollection.Controller;

import com.example.DataCollection.Model.Movie;
import com.example.DataCollection.Service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fill")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get-now-playing")
    public List<Movie> listMovies() {
        return movieService.getMovies();
    }

    @PostMapping("/now-playing")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }


}
