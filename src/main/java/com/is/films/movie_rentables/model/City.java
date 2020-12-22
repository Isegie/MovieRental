package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "city")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "city")
    private String cityName;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @OneToMany(mappedBy="city")
    private Set<Address> addresses;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    public City(String cityName, LocalDateTime lastUpdate) {
        this.cityName = cityName;
        this.lastUpdate = lastUpdate;
    }
}
