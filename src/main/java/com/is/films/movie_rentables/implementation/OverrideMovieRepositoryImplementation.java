package com.is.films.movie_rentables.implementation;

import com.is.films.movie_rentables.model.Film;
import com.is.films.movie_rentables.repository.OverrideMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
/**
 * Override of crud repository methods
 *
 * @author Ivan Segota
 */
@Repository("movieOverrideRepository")
public class OverrideMovieRepositoryImplementation {


    @Qualifier("movieOverrideRepository")
    private OverrideMovieRepository overrideMovieRepository;

    @Autowired
    public void setOverrideMovieRepository(OverrideMovieRepository overrideMovieRepository) {
        this.overrideMovieRepository = overrideMovieRepository;
    }

    public Film save(Film film) {
        return overrideMovieRepository.save(film);
    }
}
