package org.example.controllers;

import org.example.models.Discount;
import org.example.models.Reservation;
import org.example.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    //    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final Reservation reservationSerive;
    private final DiscountService discountService;

    @Autowired
    public ReservationController(ReservaionService)


    // Endpoint to apply a discount to a reservation
    @PostMapping("/{reservationId}/discounts/{discountCode}")
    public Reservation applyDiscount(@PathVariable Long reservationId, @PathVariable String discountCode) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        Discount discount = discountService.getDiscountByCode(discountCode); // Assuming you have this method
        reservationService.applyDiscountToReservation(reservationId, discount);
        return reservation; // The updated reservation is returned after discount application
    }
}