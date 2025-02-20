package com.bimuan.freshpress.model;

import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String preferredPaymentMethod;

    @ElementCollection
    private List<Enums.ServiceType> preferredServices;

    @OneToMany(mappedBy = "customer")
    private List<Booking> bookings;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
}
