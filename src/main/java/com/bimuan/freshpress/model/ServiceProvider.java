package com.bimuan.freshpress.model;

import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service_providers")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceProviderId;

    private String businessName;
    private String certifications;
    private String serviceAreas;
    private double hourlyRate;
    private String availability;
    private Integer totalJobsCompleted;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Enums.ServiceType> offeredServices;

    private boolean backgroundChecked;
    private String businessLicenseNumber;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy = "serviceProvider")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "serviceProvider")
    private List<Review> reviews;

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Service> services;

}
