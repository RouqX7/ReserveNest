package org.example.services;

import org.example.models.Discount;
import org.example.models.Reservation;
import org.example..reposiories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final DiscountService discountService;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, DiscountService discountService) {
        this.reservationRepository = reservationRepository;
        this.discountService = discountService;
    }

    public Reservation fetchReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
    }


    // Method to apply discount to reservation
    public Reservation applyDiscountToReservation(Long reservationId, Discount discount) {
        Reservation reservation = fetchReservationById(reservationId);
        reservation.applyDiscount(discount);
        return reservationRepository.save(reservation); // Save and return the updated reservation
    }
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Reservation with ID " + id + " not found.")
        );
    }
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}
