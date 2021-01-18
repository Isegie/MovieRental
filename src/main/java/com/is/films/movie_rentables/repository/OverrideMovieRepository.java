package com.is.films.movie_rentables.repository;

import com.is.films.movie_rentables.model.Film;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ivan Segota
 */
public interface OverrideMovieRepository extends CrudRepository<Film, Long> {
    Film save(Film film);
}
