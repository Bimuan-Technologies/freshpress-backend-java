package com.bimuan.freshpress.model;


import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    private String serviceName;
    private String description;
    private double basePrice;
    private double additionalFees;
    private boolean isActive;

//    @ManyToMany(mappedBy = "service")
//    private List<ServiceProvider> serviceProviders;

    @Enumerated(EnumType.STRING)
    private Enums.ServiceType serviceType;

    // Getters and Setters
}
