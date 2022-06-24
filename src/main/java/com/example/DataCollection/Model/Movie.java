package com.example.DataCollection.Model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "Movie")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Movie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "movie_id", nullable = false)
    private Long movieId;
    @Column(name = "title")
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "popularity")
    private BigDecimal popularity;
    @Column(name = "adult")
    private Boolean adult;
    @Column(name = "status")
    private String status;
    @Column(name = "release_date")
    private LocalDate release_date;

    public Movie(Long movieId, String title, String genre, BigDecimal popularity, Boolean adult, String status, LocalDate release_date) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.popularity = popularity;
        this.adult = adult;
        this.status = status;
        this.release_date = release_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return movieId != null && Objects.equals(movieId, movie.movieId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
