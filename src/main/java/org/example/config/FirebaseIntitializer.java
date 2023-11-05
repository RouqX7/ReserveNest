package org.example.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class FirebaseIntitializer {

    @PostConstruct
    public void initializeFirebase() {
        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(
                    Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("hotelreservespring-firebase-adminsdk-92euw-17895c0729.json"))
            );

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .setDatabaseUrl("https://hotelreservespring-default-rtdb.europe-west1.firebasedatabase.app/")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            // Handle exceptions, e.g., Firebase initialization errors
        }
    }
}