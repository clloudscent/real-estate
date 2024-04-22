package me.hoseong.realestate.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "property")
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name ="owner_id")
    private String ownerId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

//    @Enumerated(EnumType.STRING)
    @Column(name = "property_type", nullable = false)
    private String propertyType;

    @Column(name ="square_feet")
    private Double squareFeet;

//    @Enumerated(EnumType.STRING)
    @Column(name = "structure_type")
    private String structureType;

    @Column(name = "construction_date")
    private LocalDateTime constructionDate;

    @Column(name = "station_influence_area")
    private boolean isStationInfluenceArea;

    @Column
    private String city;

    @Column
    private String address;

//    @Enumerated(EnumType.STRING)
    @Column(name = "sale_status", nullable = false)
    private String saleStatus;

    @Column(precision = 9, scale = 6)
    private Double latitude;

    @Column(precision = 9, scale = 6)
    private Double longitude;

    @Column
    private LocalDateTime createdTime = LocalDateTime.now();

    @Column
    private LocalDateTime updatedTime = LocalDateTime.now();

    // getters and setters

   /* public enum PropertyType {
        rental, sale
    }

    public enum SaleStatus {
        on_sale, sold_out
    }

    public enum StructureType{
        wooden, masonry, steel_frame, concrete
    }*/
}

