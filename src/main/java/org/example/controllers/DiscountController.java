package org.example.controllers;

import com.example.hotelreservationsystem.models.Discount;
import com.example.hotelreservationsystem.models.DiscountType;
import com.example.hotelreservationsystem.models.Reservation;
import com.example.hotelreservationsystem.services.DiscountService;

import java.util.List;

public class DiscountController {
    private final DiscountService discountService;

    // Constructor injection of the DiscountService
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    // Endpoint to get all active discounts
    public List<Discount> getActiveDiscounts() {
        return discountService.getActiveDiscounts();
    }

    // Endpoint to create a discount
    public Discount createDiscount(String code, String name, String description, DiscountType discountType, double value, Discount.DiscountCriteria criteria) {
        return discountService.createDiscount(code, name, description, discountType, value, criteria);
    }

    // Endpoint to edit a discount
    public Discount editDiscount(String code, Double newValue, String newDescription) {
        return discountService.editDiscount(code, newValue, newDescription);
    }

    // Endpoint to deactivate a discount
    public void deactivateDiscount(String code) {
        discountService.deactivateDiscount(code);
    }

    // Endpoint to apply a discount to a reservation
    public double applyDiscountToReservation(Long reservationId, String discountCode) {
        // You'll need to fetch the reservation by ID from your data source here
        Reservation reservation = fetchReservationById(reservationId);
        return discountService.applyDiscount(reservation, discountCode);
    }

    // Method to fetch a reservation by ID (you'll need to implement the logic to fetch from your data source)
    private Reservation fetchReservationById(Long reservationId) {
        // Fetching logic (using repository or directly from a data store)
        // Placeholder for actual implementation
        throw new UnsupportedOperationException("fetchReservationById not implemented yet.");
    }

    // Other controller methods as needed...
}