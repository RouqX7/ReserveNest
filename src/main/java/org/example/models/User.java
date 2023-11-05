package org.example.models;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class User {
    @NotNull(message = "Username cannot be null")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    @Email(message = "Email should be valid")

    private String email;
    private UserProfile userProfile;

    public User(String username, String password, String email, UserProfile userProfile) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userProfile = userProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userProfile=" + userProfile +
                '}';
    }


    public static class UserProfile {
        @NotNull(message = "Profile name cannot be null")
        @NotBlank(message = "Profile name cannot be blank")
        private String name;
        private String phoneNo;
        private String address;
        private String dob;
        private String nationality;
        private String paymentInfo;
        private String reservationHistory;
        private String preferences;
        private String specialRequests;
        private String membershipLevel;

        public UserProfile(String phoneNo, String name, String address, String dob, String nationality, String paymentInfo, String reservationHistory, String preferences, String specialRequests, String membershipLevel) {
            this.phoneNo = phoneNo;
            this.address = address;
            this.dob = dob;
            this.nationality = nationality;
            this.paymentInfo = paymentInfo;
            this.reservationHistory = reservationHistory;
            this.preferences = preferences;
            this.specialRequests = specialRequests;
            this.membershipLevel = membershipLevel;
            this.name = name;
        }

        public UserProfile(){

        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getPaymentInfo() {
            return paymentInfo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPaymentInfo(String paymentInfo) {
            this.paymentInfo = paymentInfo;
        }

        public String getReservationHistory() {
            return reservationHistory;
        }

        public void setReservationHistory(String reservationHistory) {
            this.reservationHistory = reservationHistory;
        }

        public String getPreferences() {
            return preferences;
        }

        public void setPreferences(String preferences) {
            this.preferences = preferences;
        }

        public String getSpecialRequests() {
            return specialRequests;
        }

        public void setSpecialRequests(String specialRequests) {
            this.specialRequests = specialRequests;
        }

        public String getMembershipLevel() {
            return membershipLevel;
        }

        public void setMembershipLevel(String membershipLevel) {
            this.membershipLevel = membershipLevel;
        }

        @Override
        public String toString() {
            return "UserProfile{" +
                    "name='" + name + '\'' +
                    ", phoneNo='" + phoneNo + '\'' +
                    ", address='" + address + '\'' +
                    ", dob='" + dob + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", paymentInfo='" + paymentInfo + '\'' +
                    ", reservationHistory='" + reservationHistory + '\'' +
                    ", preferences='" + preferences + '\'' +
                    ", specialRequests='" + specialRequests + '\'' +
                    ", membershipLevel='" + membershipLevel + '\'' +
                    '}';
        }
    }
}
