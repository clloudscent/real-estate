package me.hoseong.realestate.entity;

import javax.persistence.*;

@Entity
@Table(name = "rental_detail")
public class RentalDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "propertyId", nullable = false)
    private Property property;

    @Column
    private String leasePeriod;

    @Column
    private Double deposit;

    // getters and setters
}

