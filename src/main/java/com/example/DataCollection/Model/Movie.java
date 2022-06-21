package com.example.DataCollection.Model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "movie_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "genre", length = 50)
    private String genre;

    @Column(name = "popularity", precision = 131089)
    private BigDecimal popularity;

    @Column(name = "adult")
    private Boolean adult;

    @Column(name = "status", length = 50)
    private String status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
