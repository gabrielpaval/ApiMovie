package com.example.DataCollection.Service;

import com.example.DataCollection.Dao.MovieDao;
import com.example.DataCollection.Model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccesService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> selectMovies() {
        var sql= """
                SELECT *
                FROM Movie
                """;
        return jdbcTemplate.query(sql,new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        var sql= """
                INSERT INTO Movie(title,genre,popularity,adult,status,release_date)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        return jdbcTemplate.update(
                sql,
                movie.getGenre(),
                movie.getPopularity(),
                movie.getAdult(),
                movie.getStatus(),
                movie.getRelease_date()
        );
    }

    @Override
    public Optional<Movie> selectMovieById(Long id) {
        var sql= """
                SELECT * 
                FROM Movie
                WHERE movie_id=?
                """;
        return jdbcTemplate.query(sql,new MovieRowMapper(),id)
                .stream()
                .findFirst();
    }
}
