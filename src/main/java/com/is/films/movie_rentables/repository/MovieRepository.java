package com.is.films.movie_rentables.repository;

import com.is.films.movie_rentables.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Film, Long> {

    List<Film> findAll();

    Optional<Film> findFilmById(Long id);

    @Query(name = "Film.movieByActorsId", nativeQuery = true)
    Optional<Film> findById(@Param("id") Long id);

    @Query(name = "Film.moviesByActorsId", nativeQuery = true)
    List<Film> fetchMoviesByActorsId(@Param("id") Long id);

    @Query(name = "Film.moviesByActorsName", nativeQuery = true)
    List<Film> fetchMoviesByActorsName(@Param("actorsFirstName") String actorsFirstName);

    @Query(name = "Film.actorsByMovieTitle", nativeQuery = true)
    Object[] fetchActorsByMovieTitle(@Param("movieTitle") String movieTitle);
}
