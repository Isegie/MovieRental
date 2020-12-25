package com.is.films.movie_rentables.command;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class MovieCommand {
    @NotBlank(message = "Movie title must not be empty")
    @JsonProperty("movieTitle")
    private String movieTitle;
    @NotBlank(message = "Movie description must not be empty")
    @JsonProperty("movieDescription")
    private String movieDescription;
    @NotBlank(message = "Year of release must not be empty")
    @JsonProperty("releaseYear")
    private int releaseYear;
    @NotNull(message = "Number of rental days must be entered")
    @Positive(message = "Number of rental duration must be more than 1 day")
    @Max(message = "Rental duration can last only 8 days", value = 8)
    @JsonProperty("rentalDuration")
    private int rentalDuration;
    @NotNull(message = "Rental rate must be entered")
    @Positive(message = "Rental rate must be a positive number")
    @JsonProperty("rentalRate")
    private double rentalRate;
    @NotNull(message = "Movie length rate must be entered")
    @Positive(message = "Movie length must be a positive number")
    @JsonProperty("movieLength")
    private double movieLength;
    @NotNull(message = "Replacement cost rate must be entered")
    @Positive(message = "Replacement cost must be a positive number")
    @JsonProperty("replacementCost")
    private double replacementCost;
    @NotBlank(message = "Movie rating must not be empty")
    @JsonProperty("movieRating")
    private String movieRating;
    @NotBlank(message = "Special features must not be empty")
    @JsonProperty("specialFeatures")
    private String specialFeatures;
    @NotBlank(message = "Full text must not be empty")
    @JsonProperty("fullText")
    private String fullText;
    @NotNull(message = "Last update must not be empty")
    @JsonProperty("lastUpdate")
    private LocalDateTime lastUpdate;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public double getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(double movieLength) {
        this.movieLength = movieLength;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(String movieRating) {
        this.movieRating = movieRating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
