package com.example.hotelreservationsystem.services;

import com.example.hotelreservationsystem.models.Discount;
import com.example.hotelreservationsystem.models.DiscountType;
import com.example.hotelreservationsystem.models.Reservation;
import com.example.hotelreservationsystem.repositories.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//
public class DiscountService {

    //If this is made into a web app it will have spring web annotations to handle Http requests

    // A thread-safe list to hold discounts. This is for example purposes only.
    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount getDiscountByCode(String discountCode) {
        return discountRepository.findByCode(discountCode)
                .orElseThrow(() -> new IllegalArgumentException("Discount with code " + discountCode + " not found"));
    }

    public List<Discount> getActiveDiscounts() {
        return discountRepository.findAllByIsActive(true);
    }

    public Discount createDiscount(String code, String name, String description, DiscountType discountType, double value, Discount.DiscountCriteria criteria) {
        // Assuming 'Discount' class has a constructor that accepts 'criteria' and 'active' status is managed separately or within criteria
        Discount discount = new Discount(code, name, description, discountType, value, criteria);
        // Assuming that you manage the activation of discounts based on certain criteria
        // If your 'Discount' class includes a boolean for 'isActive', ensure to set it appropriately
        discountRepository.save(discount);
        return discount; // Return the newly created discount object after saving to repository
    }

    public Discount editDiscount(String code, Double newValue, String newDescription) {
        Discount discount = getDiscountByCode(code);
        discount.setValue(newValue);
        discount.setDescription(newDescription);
        return discountRepository.save(discount);
    }

    public void deactivateDiscount(String code) {
        Discount discount = getDiscountByCode(code);
        discount.setActive(false);
        discountRepository.save(discount);
    }

    public double applyDiscount(Reservation reservation, String code) {
        Discount discount = getDiscountByCode(code);
        if (discount.isActive() && discount.applyTo(reservation)) {
            double discountedAmount = discount.calculateDiscountedAmount(reservation.getPrice());
            reservation.setPrice(discountedAmount); // Presuming there is a setter for price
            // Assuming you have a reservation repository to update the reservation
            // reservationRepository.save(reservation); // Uncomment or add this line if you have a reservation repository
            return discountedAmount;
        } else {
            throw new IllegalArgumentException("Discount code is not applicable or not active.");
        }
    }

    // Find a discount by code
//    public Discount findDiscountByCode(String code) {
//        return discounts.stream().filter(d -> d.getCode().equals(code) && d.isActive()).findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("No active discount found for code: " + code));
//    }

}
