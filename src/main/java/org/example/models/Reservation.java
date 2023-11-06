{package org.example.models;

import java.time.LocalDate;

    public class Reservation {

        private User user;
        private String reservationId;
        private String customerId;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private String roomType;
        private double price;
        private String customerMembershipLevel;


        public Reservation(String reservationId, String customerId, LocalDate checkInDate, LocalDate checkOutDate, String roomType, double price,
                           String customerMembershipLevel) {
            this.reservationId = reservationId;
            this.customerId = customerId;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.roomType = roomType;
            this.price = price;
            this.customerMembershipLevel = customerMembershipLevel;
        }

        public Reservation() {

        }


        public String getReservationId() {
            return reservationId;
        }

        public void setReservationId(String reservationId) {
            this.reservationId = reservationId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public LocalDate getCheckInDate() {
            return checkInDate;
        }

        public void setCheckInDate(LocalDate checkInDate) {
            this.checkInDate = checkInDate;
        }

        public LocalDate getCheckOutDate() {
            return checkOutDate;
        }

        public void setCheckOutDate(LocalDate checkOutDate) {
            this.checkOutDate = checkOutDate;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
        public String getCustomerMembershipLevel() {
            return customerMembershipLevel;
        }

        public void setCustomerMembershipLevel(String customerMembershipLevel) {
            this.customerMembershipLevel = customerMembershipLevel;
        }

        public User getUser() {
            return user;
        }

        @Override
        public String toString() {
            return "Reservation{" +
                    "reservationId='" + reservationId + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", checkInDate=" + checkInDate +
                    ", checkOutDate=" + checkOutDate +
                    ", roomType='" + roomType + '\'' +
                    ", price=" + price +
                    ", customerMembershipLevel='" + customerMembershipLevel + '\'' +
                    '}';
        }
    }

