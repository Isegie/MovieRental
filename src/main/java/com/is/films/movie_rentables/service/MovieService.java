package com.is.films.movie_rentables.service;

import com.is.films.movie_rentables.command.MovieCommand;
import com.is.films.movie_rentables.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDTO> findAll();

    List<MovieDTO> findByActorsId(Long id);

    List<MovieDTO> findByActorsName(String actorsFirstName);

    Object[] fetchActorsByMovieName(String movieTitle);

    Optional<MovieDTO> findMovieById(Long id);

    Optional<MovieDTO> saveMovie(MovieCommand movieCommand);

}
