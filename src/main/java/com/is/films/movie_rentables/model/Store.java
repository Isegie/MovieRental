package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "store")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Store implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @OneToOne
    @MapsId
    @JoinColumn(name = "store_id")
    private Staff staff;

}
