package com.example.DataCollection.Service;

import com.example.DataCollection.Dao.MovieDao;
import com.example.DataCollection.Exception.NotFoundException;
import com.example.DataCollection.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    public List<Movie> getMovies() {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {

        int result = movieDao.insertMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("oops something went wrong");
        }
    }
    public Movie getMovie(Long id) {
        return movieDao.selectMovieById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
    }

}
