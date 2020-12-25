package com.is.films.movie_rentables.service;

import com.is.films.movie_rentables.command.MovieCommand;
import com.is.films.movie_rentables.dto.MovieDTO;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDTO> findAll();

    List<MovieDTO> findByActors(Long id);

    Optional<MovieDTO> findFilmById(Long id);

    Optional<MovieDTO> saveMovie(MovieCommand movieCommand);
}
