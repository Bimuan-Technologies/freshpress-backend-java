package com.bimuan.freshpress.model;


import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long bookingId;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Enums.BookingStatus status = Enums.BookingStatus.PENDING;

        @ManyToOne
        @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
        private Customer customer;

        @ManyToOne
        @JoinColumn(name = "service_provider_id", referencedColumnName = "serviceProviderId")
        private ServiceProvider serviceProvider;

        @ManyToOne
        @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
        private Service service;

        private LocalDateTime bookingDate;
        private LocalDateTime scheduleDate;
        private int duration;
        private String specialInstructions;
        private double totalCost;

        @Enumerated(EnumType.STRING)
        private Enums.ServiceType serviceType;



        // Getters and Setters

}
