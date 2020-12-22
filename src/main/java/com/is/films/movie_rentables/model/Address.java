package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "address")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "address")
    private String addressField;
    @Getter
    @Setter
    @Column(name = "address2")
    private String secondAddressField;
    @Getter
    @Setter
    @Column(name = "district")
    private String districtName;
    @Getter
    @Setter
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
    @Getter
    @Setter
    @OneToMany(mappedBy="address")
    private Set<Staff> staffMembers;
    @Getter
    @Setter
    @OneToMany(mappedBy="address")
    private Set<Customer> customers;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    public Address(String addressField, String secondAddressField, String districtName, LocalDateTime lastUpdate) {
        this.addressField = addressField;
        this.secondAddressField = secondAddressField;
        this.districtName = districtName;
        this.lastUpdate = lastUpdate;
    }
}
