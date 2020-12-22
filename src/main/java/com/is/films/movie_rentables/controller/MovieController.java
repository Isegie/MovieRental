package com.is.films.movie_rentables.controller;

import com.is.films.movie_rentables.dto.MovieDTO;
import com.is.films.movie_rentables.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /*
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieByActorId(@PathVariable final Long id) {
        return movieService.findById(id).map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build());
    }
    */
    @GetMapping("/{id}")
    public ResponseEntity<List<MovieDTO>> getMovieByActorId(@PathVariable final Long id) {
       // List<MovieDTO> movies = movieService.findByActors(id);
        return new ResponseEntity(movieService.findByActors(id).stream().map(movieDTO -> ResponseEntity.status(HttpStatus.OK)
                .body(movieDTO)),HttpStatus.OK);
    }

}
