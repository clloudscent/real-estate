package me.hoseong.realestate.entity;

import javax.persistence.*;

@Entity
@Table(name = "nearby_subway")
public class NearbySubway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "propertyId", nullable = false)
    private Property property;

    @Column(nullable = false)
    private String stationName;

    @Column
    private Integer walkingDistance;

    // getters and setters
}

