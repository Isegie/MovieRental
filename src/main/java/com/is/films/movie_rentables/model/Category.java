package com.is.films.movie_rentables.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "category")
@NoArgsConstructor
@EqualsAndHashCode
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String categoryName;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @OneToOne
    @MapsId
    @JoinColumn(name = "category_id")
    private Film movie;
    public Category(String categoryName, LocalDateTime lastUpdate) {
        this.categoryName = categoryName;
        this.lastUpdate = lastUpdate;
    }
}
