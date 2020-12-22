package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "title")
    private String movieTitle;
    @Getter
    @Setter
    @Column(name = "description")
    private String movieDescription;
    @Getter
    @Setter
    @Column(name = "release_year")
    private int releaseYear;
    @Getter
    @Setter
    @Column(name = "rental_duration")
    private int rentalDuration;
    @Getter
    @Setter
    @Column(name = "rental_rate")
    private double rentalRate;
    @Getter
    @Setter
    @Column(name = "length")
    private double movieLength;
    @Getter
    @Setter
    @Column(name = "replacement_cost")
    private double replacementCost;
    @Getter
    @Setter
    @Column(name = "rating")
    private String movieRating;
    @Getter
    @Setter
    @Column(name = "special_features", columnDefinition = "TEXT")
    private String specialFeatures;
    @Getter
    @Setter
    @Column(name = "fulltext", columnDefinition = "TEXT")
    private String fullText;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Category category;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @Getter
    @Setter
    @OneToMany(mappedBy = "movie")
    private Set<Inventory> inventories;
    @Getter
    @Setter
    @ManyToMany(targetEntity = Actor.class)
    @JoinTable(name = "film_actor",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")})
    private List<Actor> actors;

    public Film(String movieTitle, String movieDescription, int releaseYear, int rentalDuration, double rentalRate, double movieLength, double replacementCost, String movieRating, String specialFeatures, String fullText, LocalDateTime lastUpdate) {
        this.movieTitle = movieTitle;
        this.movieDescription = movieDescription;
        this.releaseYear = releaseYear;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.movieLength = movieLength;
        this.replacementCost = replacementCost;
        this.movieRating = movieRating;
        this.specialFeatures = specialFeatures;
        this.fullText = fullText;
        this.lastUpdate = lastUpdate;
    }
}
