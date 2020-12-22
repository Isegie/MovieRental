package com.is.films.movie_rentables.service;

import com.is.films.movie_rentables.dto.MovieDTO;
import com.is.films.movie_rentables.model.Film;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDTO> findAll();
    //Optional<MovieDTO> findById(Long id);
    List<MovieDTO> findByActors(Long id);
}
