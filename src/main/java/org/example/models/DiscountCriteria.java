package com.example.hotelreservationsystem.models;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

@Entity
public class Discount {
    private Long id;
    private String code; // Assuming each discount has a unique code.
    private String name;
    private String description;
    private DiscountType discountType;
    private double value; // The value of the discount (percentage or flat rate)
    private boolean isActive;
    private DiscountCriteria criteria;
    public interface DiscountCriteria {
        boolean isSatisfiedBy(Reservation reservation);
        boolean isApplicable(Reservation reservation);
    }


//    @Embedded // If criteria is an embeddable class
//    private DiscountCriteria criteria;


    public Discount(){
        // Default constructor if needed for frameworks or instantiation logic
    }

    public Discount(String code, String name, String description, DiscountType discountType, double value,DiscountCriteria criteria ) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.discountType = discountType;
        this.value = value;
        this.isActive = true; // Discounts are active by default when created
        this.criteria = criteria;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public DiscountCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(DiscountCriteria criteria) {
        this.criteria = criteria;
    }

    // Checks if the discount can be applied to the given reservation
    // The applyTo method uses the DiscountCriteria object to check if the discount applies

    public boolean applyTo(Reservation reservation) {
        if (!isActive) {
            return false; // If the discount is not active, it cannot be applied
        }

        // Check the criteria to see if the discount can be applied
        return criteria.isSatisfiedBy(reservation);
    }

    // You could define a method to check membership level if it's a common criteria type
    private boolean checkMembershipLevel(Reservation reservation, String requiredLevel) {
        User user = reservation.getUser(); // Ensure getUser is a method in Reservation that returns a User object
        if (user != null && user.getUserProfile() != null) {
            String userMembershipLevel = user.getUserProfile().getMembershipLevel();
            return userMembershipLevel.equals(requiredLevel);
        }
        return false;
    }
    // calculates the discounted amount based on discount type and value
    public double calculateDiscountedAmount(double amount) {
        return switch (discountType) {
            case PERCENTAGE -> amount * (value / 100.0);
            case FLAT_RATE -> value;
            default -> 0;
        };
    }

    // Example usage would typically be in a method, such as main() or a dedicated test method:
    public static void main(String[] args) {
        Discount.DiscountCriteria goldMemberCriteria = new MembershipLevelDiscountCriteria("Gold");
        Discount goldMemberDiscount = new Discount("GOLD10", "Gold Membership Discount", "10% off for Gold members", DiscountType.PERCENTAGE, 10.0, goldMemberCriteria);

        Reservation reservation = new Reservation(); // ... create a reservation instance
        boolean discountApplies = goldMemberDiscount.applyTo(reservation);
    }


    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discountType=" + discountType +
                ", value=" + value +
                ", isActive=" + isActive +
                '}';
    }


// toString(), equals(), and hashCode() methods as necessary
    // ...
}
