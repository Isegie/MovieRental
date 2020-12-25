package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "staff")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "staff_id")
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
    @Column(name = "active")
    private boolean active;
    @Getter
    @Setter
    @Column(name = "username")
    private String username;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @Lob
    @Column(name = "picture")
    private byte[] picture;
    @Getter
    @Setter
    @OneToMany(mappedBy="staff")
    private Set<Payment> payments;
    @Getter
    @Setter
    @OneToMany(mappedBy="staff")
    private List<Rental> rentals;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="address_id")
    private Address address;
    @Getter
    @Setter
    @OneToOne(mappedBy = "staff", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Store store;

    public Staff(String firstName, String lastName, String email, boolean active, String username, String password, LocalDateTime lastUpdate, byte[] picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdate = lastUpdate;
        this.picture = picture;
    }
}
