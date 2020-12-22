package com.is.films.movie_rentables.implementation;

import com.is.films.movie_rentables.dto.MovieDTO;
import com.is.films.movie_rentables.model.Film;
import com.is.films.movie_rentables.repository.MovieRepository;
import com.is.films.movie_rentables.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieImplementation implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> findAll() {
        return movieRepository.findAll().stream()
                .map(this::mapMovieToDto).collect(Collectors.toList());
    }

    /*
    @Override
    public Optional<MovieDTO> findByActors(Long id) {
        return Optional.ofNullable(movieRepository.findById(id)
                .map(this::mapMovieToDto).stream().findFirst()).orElse(null);

    }
    */
    @Override
    public List<MovieDTO> findByActors(Long id) {
        List<Film> movies = movieRepository.fetchMoviesByActorsId(id);
        return movies.stream().map(this::mapMovieToDto).collect(Collectors.toList());
    }

    private MovieDTO mapMovieToDto(Film film) {
        return new MovieDTO(film.getMovieTitle(), film.getMovieDescription(), film.getReleaseYear(),
                film.getRentalDuration(), film.getRentalRate(), film.getMovieLength(), film.getReplacementCost(),
                film.getMovieRating(), film.getSpecialFeatures(), film.getFullText(), film.getLastUpdate());
    }
}
