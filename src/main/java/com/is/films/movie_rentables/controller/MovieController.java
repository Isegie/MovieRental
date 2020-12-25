package com.is.films.movie_rentables.controller;

import com.is.films.movie_rentables.command.MovieCommand;
import com.is.films.movie_rentables.dto.MovieDTO;
import com.is.films.movie_rentables.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return new ResponseEntity(movieService.findByActors(id).stream().map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable final Long id) {
        return movieService.findFilmById(id).map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build());
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@Valid @RequestBody final MovieCommand movieCommand) {
        return movieService.saveMovie(movieCommand).map(studentDTO -> ResponseEntity.status(HttpStatus.CREATED)
                .body(studentDTO)).orElseGet(() -> ResponseEntity
                .status(HttpStatus.CONFLICT)
                .build());
    }

}
