package org.example.controllers;

import jakarta.validation.constraints.Email;
import org.example.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/validation")
public class ValidationController {
    private final ValidationService validationService;

    @Autowired
    public ValidationController(ValidationService validationService) {
        this.validationService = validationService;
    }


    @PostMapping("/validate-email")
    public ResponseEntity<Boolean> validateEmail(@Email @RequestParam String email) {
        boolean isValid = validationService.isValidEmail(email);
        return new ResponseEntity<>(isValid, isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/validate-username")
    public ResponseEntity<Boolean> validateUsername(@RequestParam String username) {
        boolean isValid = validationService.isValidUsername(username);
        return new ResponseEntity<>(isValid, isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @PostMapping("/validate-password")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String password) {
        boolean isValid =validationService.isValidPassword(password);
        return new ResponseEntity<>(isValid, isValid ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


}


