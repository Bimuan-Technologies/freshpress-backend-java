package com.bimuan.freshpress.model;


import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private ServiceProvider serviceProvider;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enums.ServiceType serviceType;

    private String description;
    private String serviceName;

    private BigDecimal price;
    private BigDecimal additionalFees;

    @Column(nullable = false)
    private String availability; // Monday 9-12, Tuesday 14-17"
    private boolean isActive;
    private Double averageRating; // Calculated from reviews

    @Column(nullable = false)
    private String serviceArea;
//    @ManyToMany(mappedBy = "service")
//    private List<ServiceProvider> serviceProviders;



    // Getters and Setters
}
