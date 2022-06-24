package com.example.DataCollection.Dao;

import com.example.DataCollection.Model.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieDao {
    List<Movie> selectMovies();
    int insertMovie(Movie movie);
    Optional<Movie> selectMovieById(Long id);
}
