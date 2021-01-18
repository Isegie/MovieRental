package com.is.films.movie_rentables.model;

import lombok.*;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actor")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Actor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Column(name = "actor_id",updatable = false)
    private Long id;
    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;
    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;
    @Getter
    @Setter
    @Column(name = "last_update")
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    private LocalDateTime lastUpdate;
    @ManyToMany(targetEntity = Film.class, mappedBy = "actors")
    private List<Film> movies;

    public Actor(String firstName, String lastName, LocalDateTime lastUpdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }
}
