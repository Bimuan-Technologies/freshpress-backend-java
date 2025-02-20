package com.bimuan.freshpress.model;


import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "service_provider_id", referencedColumnName = "serviceProviderId")
    private ServiceProvider serviceProvider;

    @Enumerated(EnumType.STRING)
    private Enums.ServiceType serviceType;

    private int rating;
    private String comment;
    private LocalDateTime reviewDate;

    private boolean isVerified;
}

