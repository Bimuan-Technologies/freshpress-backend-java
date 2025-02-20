package com.bimuan.freshpress.model;

import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dispatchs")
public class Dispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dispatchId;

    private String preferredPaymentMethod;

    @OneToMany(mappedBy = "dispatch")
    private List<Booking> bookings;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
}
