package com.example.DataCollection.Service;

import com.example.DataCollection.Model.Movie;
import com.example.DataCollection.Repository.MovieRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Data
public class MovieServiceImpl {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getAllMovies() {

        return movieRepository.findAll();
    }
}
