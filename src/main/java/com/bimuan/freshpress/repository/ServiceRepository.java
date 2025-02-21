package com.bimuan.freshpress.repository;

import com.bimuan.freshpress.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT s FROM Service s WHERE " +
            "(:location IS NULL OR s.serviceArea LIKE %:location%) " +
            "AND (:serviceType IS NULL OR s.serviceType = :serviceType) " +
            "AND (:minPrice IS NULL OR s.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR s.price <= :maxPrice) " +
            "AND (:minRating IS NULL OR s.averageRating >= :minRating)")
    List<Service> searchServices(
            @Param("location") String location,
            @Param("serviceType") String serviceType,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            @Param("minRating") Double minRating);
}
