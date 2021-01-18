package com.is.films.movie_rentables.controller;

import com.is.films.movie_rentables.command.MovieCommand;
import com.is.films.movie_rentables.dto.MovieDTO;
import com.is.films.movie_rentables.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ivan Segota
 */
@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.findAll();
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<List<MovieDTO>> getMovieByActorId(@PathVariable final Long id) {
        return new ResponseEntity(movieService.findByActorsId(id).stream().map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)), HttpStatus.OK);
    }

    @GetMapping("/list/actors/name")
    public ResponseEntity<List<MovieDTO>> getMovieByActorsName(@RequestParam(value = "actorsFirstName", required = true) final String actorsFirstName) {
        return new ResponseEntity(movieService.findByActorsName(actorsFirstName).stream().map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)), HttpStatus.OK);
    }

    @GetMapping("/movies/titles")
    public ResponseEntity<List<Object>> fetchActorsByMovieName(@RequestParam(value = "movieTitle", required = true) final String movieTitle) {
        return Optional.ofNullable(Arrays.stream(movieService.fetchActorsByMovieName(movieTitle)).collect(Collectors.toList()))
                .map(actors -> ResponseEntity.ok().body(actors))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable final Long id) {
        return movieService.findMovieById(id).map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)).orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@Valid @RequestBody final MovieCommand movieCommand) {
        return movieService.saveMovie(movieCommand).map(movieDTO -> ResponseEntity.status(HttpStatus.CREATED)
                .body(movieDTO)).orElseGet(() -> ResponseEntity
                .status(HttpStatus.CONFLICT)
                .build());
    }

}
