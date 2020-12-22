package com.is.films.movie_rentables.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
public class MovieDTO {
    @Getter
    @Setter
    private String movieTitle;
    @Getter
    @Setter
    private String movieDescription;
    @Getter
    @Setter
    private int releaseYear;
    @Getter
    @Setter
    private int rentalDuration;
    @Getter
    @Setter
    private double rentalRate;
    @Getter
    @Setter
    private double movieLength;
    @Getter
    @Setter
    private double replacementCost;
    @Getter
    @Setter
    private String movieRating;
    @Getter
    @Setter
    private String specialFeatures;
    @Getter
    @Setter
    private String fullText;
    @Getter
    @Setter
    private LocalDateTime lastUpdate;

    public MovieDTO(String movieTitle, String movieDescription, int releaseYear, int rentalDuration, double rentalRate, double movieLength, double replacementCost, String movieRating, String specialFeatures, String fullText, LocalDateTime lastUpdate) {
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

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieTitle='" + movieTitle + '\'' +
                ", movieDescription='" + movieDescription + '\'' +
                ", releaseYear=" + releaseYear +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", movieLength=" + movieLength +
                ", replacementCost=" + replacementCost +
                ", movieRating='" + movieRating + '\'' +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", fullText='" + fullText + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
