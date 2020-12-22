package com.is.films.movie_rentables.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "language")
@NoArgsConstructor
@EqualsAndHashCode
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "language_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String languageName;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @OneToMany(mappedBy="language")
    private Set<Film> movies;
    public Language(String languageName, LocalDateTime lastUpdate) {
        this.languageName = languageName;
        this.lastUpdate = lastUpdate;
    }
}
