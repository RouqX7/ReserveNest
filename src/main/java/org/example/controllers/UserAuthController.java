package org.example.controllers;


import org.example.services.UserService;
import org.example.services.ValidationService;
import org.example.session.UserSession;
import org.example.view.SignInView;
import org.example.view.SignUpView;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserAuthController {
    private SignInView signInView;
    private SignUpView signUpView;
    private UserService userService;
    private ValidationService validationService;
    private UserSession userSession;


    public UserAuthController(SignInView signInView, SignUpView signUpView, UserService userService, ValidationService validationService, UserSession userSession) {
        this.signInView = signInView;
        this.signUpView = signUpView;
        this.userService = userService;
        this.validationService = validationService;
        this.userSession = userSession;
    }

    public void handleSignIn() {
        String email = signInView.getEmailFromUser();
        String password = signInView.getPasswordFromUser();
        if (!validationService.isValidEmail(email) || !validationService.isValidPassword(password)) {
            signInView.displayLoginResult(false,"Login In failed");
            return;
        }
        boolean success = Boolean.parseBoolean(userService.authenticateUser(email, password));
        if (success) {
            userSession.setAuthenticated(true);
            userSession.setUserId(userSession.getUserId()); // Or whatever identifier you use
        }
        signInView.displayLoginResult(success,"Login in failed");
    }

    public void handleSignUp() {
        String email = signUpView.getEmailFromUser();
        String password = signUpView.getPasswordFromUser();

        if (!validationService.isValidEmail(email)) {
            signUpView.showInvalidInputMessage("email");
            return;
        }

        if (!validationService.isValidPassword(password)) {
            signUpView.showInvalidInputMessage("password");
            return;
        }


        try {
            String userId = userService.registerUser(email, password);
            signUpView.showRegistrationSuccess(userId);
        } catch (Exception e) {
            signUpView.showRegistrationError(e.getMessage());
        }
        String result = userService.registerUser(email, password);
        signUpView.displayRegistrationResult(result.startsWith("User registered successfully"), result);
    }

}