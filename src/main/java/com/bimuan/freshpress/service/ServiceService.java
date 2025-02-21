package com.bimuan.freshpress.service;

import com.bimuan.freshpress.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.bimuan.freshpress.model.Service> searchServices(String location, String serviceType, BigDecimal minPrice, BigDecimal maxPrice, Double minRating) {
        return serviceRepository.searchServices(location, serviceType, minPrice, maxPrice, minRating);
    }

    public Optional<com.bimuan.freshpress.model.Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }
}
