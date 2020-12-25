package com.is.films.movie_rentables.repository;

import com.is.films.movie_rentables.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Film, Long> {
    List<Film> findAll();

    @Query("select f from Film f inner join f.actors ac where ac.id = :id order by f.id asc")
    Optional<Film> findById(@RequestParam("id") Long id);

    @Query(value = "select f.film_id,f.title,f.description,f.release_year,f.language_id," +
            "f.rental_duration,f.rental_rate,f.length,f.replacement_cost," +
            "f.rating,f.last_update,f.special_features,f.fulltext from film f inner join film_actor fa on f.film_id=fa.film_id\n" +
            "inner join actor ac on ac.actor_id=fa.actor_id where ac.actor_id= :id",nativeQuery = true)
    List<Film> fetchMoviesByActorsId(@RequestParam("id") Long id);

    Optional<Film> findFilmById(Long id);

}
