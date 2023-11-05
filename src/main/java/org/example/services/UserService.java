package org.example.services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserService {
    static {
        try {
            // Use ClassPathResource to load the file from the resources directory
            ClassPathResource serviceAccountResource = new ClassPathResource("hotelreservespring-firebase-adminsdk-92euw-17895c0729.json");

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountResource.getInputStream()))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            // Handle exception
            throw new IllegalStateException("Initialize FirebaseApp failed", e);
        }
    }
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final FirebaseAuth firebaseAuth;

    public UserService() {
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public String registerUser(String email, String password) {
        try {
            // Here we create a new user record in Firebase without any authentication
            UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                    .setEmail(email)
                    .setPassword(password); // Storing passwords like this is not secure!

            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            // User was created successfully
            return "User registered successfully with UID: " + userRecord.getUid();
        } catch (FirebaseAuthException e) {
            // If there is any exception during the creation, return the error message
            return "User registration failed: " + e.getMessage();
        }
    }

    public boolean loginUser(String email,String password) {
        try {
            // Attempt to retrieve the user record from Firebase
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);

            // If we find a user with the provided email, we consider that a successful login
            return userRecord != null;

        } catch (FirebaseAuthException e) {
            // Handle the FirebaseAuthException and consider the login as failed.
            // Depending on your error handling policy, you might want to log this exception or handle it in some way.
            return false;
        }
    }

    public String authenticateUser(String email, String password) {
        try {
            UserRecord userRecord = FirebaseAuth.getInstance().getUserByEmail(email);
            // Here you would need to verify the password, which you can't do directly with Firebase Admin SDK.
            // You should do this on the client side, and then send the ID token to the server for verification.
            // For example purposes, let's just assume the password is correct:
            return userRecord.getUid();
        } catch (Exception e) {
            logger.error("Authentication failed", e);
            return null;
        }
    }

    public String createCustomToken(String uid) {
        try {
            return FirebaseAuth.getInstance().createCustomToken(uid);
        } catch (FirebaseAuthException e) {
            logger.error("Error creating custom token", e);
            return null;
        }
    }

}
