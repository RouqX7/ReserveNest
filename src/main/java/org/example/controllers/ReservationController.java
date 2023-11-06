package org.example..controllers;

import com.example.hotelreservationsystem.models.Discount;
import com.example.hotelreservationsystem.models.Reservation;
import com.example.hotelreservationsystem.services.DiscountService;
import com.example.hotelreservationsystem.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reservations")
public class ReservationController {
    //    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final ReservationService reservationService;
    private final DiscountService discountService;



//    public void reviewReservationDetails(LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests, String roomType) {
//        System.out.println("\nPlease review your reservation details:");
//        System.out.println("Check-in Date: " + checkInDate.format(dateFormatter));
//        System.out.println("Check-out Date: " + checkOutDate.format(dateFormatter));
//        System.out.println("Number of Guests: " + numberOfGuests);
//        System.out.println("Room Type: " + roomType);
//        // Include any other details relevant to the reservation
//
//        System.out.println("\nIs this information correct? (yes/no): ");
//        // Here you would implement logic to confirm the reservation or to go back and edit details
//    }

    @Autowired
    public ReservationController( ReservationService reservationService, DiscountService discountService) {
        this.reservationService = reservationService;
        this.discountService = discountService;
    }
    // Endpoint to apply a discount to a reservation
    @PostMapping("/{reservationId}/discounts/{discountCode}")
    public Reservation applyDiscount(@PathVariable Long reservationId, @PathVariable String discountCode) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        Discount discount = discountService.getDiscountByCode(discountCode); // Assuming you have this method
        reservationService.applyDiscountToReservation(reservationId, discount);
        return reservation; // The updated reservation is returned after discount application
    }
}