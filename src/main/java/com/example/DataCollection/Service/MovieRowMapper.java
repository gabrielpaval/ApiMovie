package com.example.DataCollection.Service;

import com.example.DataCollection.Model.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Movie(
                rs.getLong("movie_id"),
                rs.getString("title"),
                rs.getString("genre"),
                rs.getBigDecimal("popularity"),
                rs.getBoolean("adult"),
                rs.getString("status"),
                LocalDate.parse(rs.getString("release_date"))
        );
    }
}
