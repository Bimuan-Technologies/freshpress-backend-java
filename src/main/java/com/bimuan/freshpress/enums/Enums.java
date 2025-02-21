package com.bimuan.freshpress.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Enums {
//    public enum UserType{
//        CUSTOMER,
//        SERVICE_PROVIDER,
//        ADMIN
//    }

    public enum ServiceType {
        HOME_CLEANING,
        OFFICE_CLEANING,
        LAUNDRY_WASH_FOLD,
        DRY_CLEANING,
        ALTERATIONS
    }

    public enum BookingStatus{
        PENDING,
        CONFIRMED,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED
    }

    public enum PaymentStatus{
        PAID,
        PENDING,
        FAILED,
        REFUNDED
    }

    public enum PaymentMethod {
        CREDIT_CARD,
        DEBIT_CARD,
        PAYPAL,
        BANK_TRANSFER,
        APPLE_PAY,
        GOOGLE_PAY
    }

    @RequiredArgsConstructor
    public enum Permission {

        ADMIN_READ("admin:read"),
        ADMIN_UPDATE("admin:update"),
        ADMIN_CREATE("admin:create"),
        ADMIN_DELETE("admin:delete"),

        SP_READ("sp:read"),
        SP_UPDATE("sp:update"),
        SP_CREATE("sp:create"),
        SP_DELETE("sp:delete"),

        CUSTOMER_READ("customer:read"),
        CUSTOMER_UPDATE("customer:update"),
        CUSTOMER_CREATE("customer:create"),
        CUSTOMER_DELETE("customer:delete"),

        DISPATCH_READ("dispatch:create"),
        DISPATCH_UPDATE("dispatch:read"),
        DISPATCH_CREATE("dispatch:update"),
        DISPATCH_DELETE("dispatch:delete")
        ;

        @Getter
        private final String permission;
    }

    @RequiredArgsConstructor
    public enum Role {

        USER(Collections.emptySet()),
        ADMIN(
                Set.of(
                        Permission.ADMIN_READ,
                        Permission.ADMIN_UPDATE,
                        Permission.ADMIN_DELETE,
                        Permission.ADMIN_CREATE,
                        Permission.SP_CREATE,
                        Permission.SP_READ,
                        Permission.SP_UPDATE,
                        Permission.SP_DELETE,
                        Permission.CUSTOMER_READ,
                        Permission.CUSTOMER_CREATE,
                        Permission.CUSTOMER_UPDATE,
                        Permission.CUSTOMER_DELETE,
                        Permission.DISPATCH_CREATE,
                        Permission.DISPATCH_READ,
                        Permission.DISPATCH_UPDATE,
                        Permission.DISPATCH_DELETE
                )
        ),

        SERVICE_PROVIDER(
                Set.of(
                        Permission.SP_READ,
                        Permission.SP_CREATE,
                        Permission.SP_UPDATE,
                        Permission.SP_DELETE
                )
        ),

        CUSTOMER(
                Set.of(
                    Permission.CUSTOMER_CREATE,
                    Permission.CUSTOMER_READ,
                    Permission.CUSTOMER_UPDATE,
                    Permission.CUSTOMER_DELETE
                )
        ),

        DISPATCH(
               Set.of(
                     Permission.DISPATCH_CREATE,
                       Permission.DISPATCH_READ,
                       Permission.DISPATCH_UPDATE,
                       Permission.DISPATCH_DELETE
               )
        );

        @Getter
        private final Set<Permission> permissions;

        public List<SimpleGrantedAuthority> getAuthorities() {
            var authorities = getPermissions()
                    .stream()
                    .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                    .collect(Collectors.toList());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
            return authorities;
        }
    }

    public enum TokenType {
        BEARER
    }
}
