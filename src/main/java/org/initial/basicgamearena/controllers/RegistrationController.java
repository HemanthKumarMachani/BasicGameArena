package org.initial.basicgamearena.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        // Log to verify it received
        System.out.println("Received registration: " + request);

        // Just send back a simple response
        return ResponseEntity.ok("User registered: " + request.getUsername());
    }

    // DTO class
    public static class UserRegistrationRequest {
        private String username;
        private String password;

        // Getters and Setters
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

        @Override
        public String toString() {
            return "UserRegistrationRequest{username='" + username + "', password='" + password + "'}";
        }
    }
}
