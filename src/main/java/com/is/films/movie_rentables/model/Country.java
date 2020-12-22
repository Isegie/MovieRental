package com.is.films.movie_rentables.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "country")
@NoArgsConstructor
@EqualsAndHashCode
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "country")
    private String countryName;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @OneToMany(mappedBy="country")
    private List<City> cities;

    public Country(String countryName, LocalDateTime lastUpdate) {
        this.countryName = countryName;
        this.lastUpdate = lastUpdate;
    }
}
