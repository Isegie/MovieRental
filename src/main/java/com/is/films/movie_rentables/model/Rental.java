package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "rental")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rental_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "rental_date")
    private LocalDate rentDate;
    @Getter
    @Setter
    @Column(name = "return_date")
    private LocalDate returnDate;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @OneToOne
    @MapsId
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @Getter
    @Setter
    @OneToMany(mappedBy = "rental")
    private Set<Payment> payments;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Rental(LocalDate rentDate, LocalDate returnDate, LocalDateTime lastUpdate) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.lastUpdate = lastUpdate;
    }
}
