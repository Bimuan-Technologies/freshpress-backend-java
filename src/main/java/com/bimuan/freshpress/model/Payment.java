package com.bimuan.freshpress.model;

import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "bookingId")
    private Booking booking;

    private Double amount;
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enums.PaymentStatus paymentStatus = Enums.PaymentStatus.PENDING;

    @Enumerated(EnumType.STRING)
    private Enums.PaymentMethod paymentMethod;

    private LocalDateTime paymentDateTime;

}
