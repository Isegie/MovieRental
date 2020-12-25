package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
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
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "activebool")
    private boolean activeBool;
    @Getter
    @Setter
    @Column(name = "create_date")
    private LocalDate createDate;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @Column(name = "active")
    private int active;
    @Getter
    @Setter
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Rental rental;
    @Getter
    @Setter
    @OneToMany(mappedBy="customer")
    private Set<Payment> payments;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;

    public Customer(String firstName, String lastName, String email, Boolean activeBool, LocalDate createDate, LocalDateTime lastUpdate, int active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activeBool = activeBool;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }
}
