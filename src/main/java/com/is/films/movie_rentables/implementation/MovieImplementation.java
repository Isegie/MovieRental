package com.is.films.movie_rentables.implementation;

import com.is.films.movie_rentables.command.MovieCommand;
import com.is.films.movie_rentables.dto.ActorDTO;
import com.is.films.movie_rentables.dto.MovieDTO;
import com.is.films.movie_rentables.model.Actor;
import com.is.films.movie_rentables.model.Film;
import com.is.films.movie_rentables.repository.MovieRepository;
import com.is.films.movie_rentables.repository.OverrideMovieRepository;
import com.is.films.movie_rentables.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieImplementation implements MovieService {

    private MovieRepository movieRepository;
    private OverrideMovieRepository overrideMovieRepository;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Autowired
    public void setOverrideMovieRepository(OverrideMovieRepository overrideMovieRepository) {
        this.overrideMovieRepository = overrideMovieRepository;
    }

    @Override
    public List<MovieDTO> findAll() {
        return movieRepository.findAll().stream()
                .map(this::mapMovieToDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> findByActorsId(Long id) {
        List<Film> movies = movieRepository.fetchMoviesByActorsId(id);
        return movies.stream().map(this::mapMovieToDto).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> findByActorsName(String actorsFirstName) {
        return movieRepository.fetchMoviesByActorsName(actorsFirstName).stream().map(this::mapMovieToDto).collect(Collectors.toList());
    }

    @Override
    public Object[] fetchActorsByMovieName(String movieTitle) {
        return movieRepository.fetchActorsByMovieName(movieTitle);
    }

    @Override
    public Optional<MovieDTO> findMovieById(Long id) {
        return Optional.ofNullable(movieRepository.findFilmById(id).map(this::mapMovieToDto).orElse(null));
    }

    @Override
    public Optional<MovieDTO> saveMovie(MovieCommand movieCommand) {
        return Optional.ofNullable(mapMovieToDto(overrideMovieRepository.
                save(mapCommandToMovie(movieCommand))));
    }

    private ActorDTO mapActorToDto(Actor actor) {
        return new ActorDTO(actor.getId().intValue(), actor.getFirstName(), actor.getLastName(), actor.getLastUpdate());
    }


    private Film mapCommandToMovie(MovieCommand movieCommand) {
        return new Film(movieCommand.getMovieTitle(), movieCommand.getMovieDescription(), movieCommand.getReleaseYear(),
                movieCommand.getRentalDuration(), movieCommand.getRentalRate(), movieCommand.getMovieLength(), movieCommand.getReplacementCost(),
                movieCommand.getMovieRating(), movieCommand.getSpecialFeatures(), movieCommand.getFullText(), movieCommand.getLastUpdate());
    }

    private MovieDTO mapMovieToDto(Film film) {
        return new MovieDTO(film.getMovieTitle(), film.getMovieDescription(), film.getReleaseYear(),
                film.getRentalDuration(), film.getRentalRate(), film.getMovieLength(), film.getReplacementCost(),
                film.getMovieRating(), film.getSpecialFeatures(), film.getFullText(), film.getLastUpdate());
    }
}
