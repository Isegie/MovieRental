package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Inventory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="film_id")
    private Film movie;
    @Getter
    @Setter
    @OneToOne(mappedBy = "inventory", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Rental rental;
    public Inventory(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
