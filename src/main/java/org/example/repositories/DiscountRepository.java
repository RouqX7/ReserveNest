package com.example.hotelreservationsystem.repositories;

import com.example.hotelreservationsystem.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
    Optional<Discount> findByCode(String code);
    List<Discount> findAllByIsActive(boolean isActive);
}