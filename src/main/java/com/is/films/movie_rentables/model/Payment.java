package com.is.films.movie_rentables.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "amount")
    private BigDecimal amount;
    @Getter
    @Setter
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="rental_id")
    private Rental rental;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    public Payment(BigDecimal amount, LocalDate paymentDate) {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
}
