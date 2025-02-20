package com.bimuan.freshpress.model;


import com.bimuan.freshpress.enums.Enums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String passwordHash;
    @Column(unique = true)
    private String phoneNumber;
    private boolean enabled;
    private String profileImageUrl;
    private String preferredLanguage;
    @Column(precision = 10, scale = 8)
    private Double latitude;
    @Column(precision = 11, scale = 8)
    private Double longitude;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Embedded
    private Address address;

    @Embeddable
    public static class Address {
        private String street;
        private String city;
        private String state;
        private String country;
        private String postalCode;
        private String formattedAddress;

        // Getters and Setters
        public String getStreet() { return street; }
        public void setStreet(String street) { this.street = street; }

        public String getCity() { return city; }
        public void setCity(String city) { this.city = city; }

        public String getState() { return state; }
        public void setState(String state) { this.state = state; }

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }

        public String getPostalCode() { return postalCode; }
        public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

        public String getFormattedAddress() { return formattedAddress; }
        public void setFormattedAddress(String formattedAddress) { this.formattedAddress = formattedAddress; }
    }


//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Enums.UserType userType = Enums.UserType.CUSTOMER;

    @Enumerated(EnumType.STRING)
    private Enums.Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


