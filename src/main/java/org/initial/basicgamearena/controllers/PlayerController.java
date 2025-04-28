//package org.initial.basicgamearena.controllers;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotBlank;
//import org.initial.basicgamearena.model.Player;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//@RestController
//@RequestMapping("/api/player")
//public class PlayerController {
//
//    @PostMapping("/register")
//    public ResponseEntity<Player> registerPlayer(@Valid @RequestBody PlayerRequest request) {
//        Player player = new Player();
//        player.setId(UUID.randomUUID().toString());
//        player.setUsername(request.getUsername());
//        player.setPassword(request.getPassword());
//        player.setX(0);
//        player.setY(0);
//        player.setHealth(100);
//        player.setScore(0);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(player);
//    }
//
//    // DTO class for the request
//    public static class PlayerRequest {
//        @NotBlank(message = "Username is required")
//        private String username;
//
//        @NotBlank(message = "Password is required")
//        private String password;
//
//        // Getters and Setters
//        public String getUsername() {
//            return username;
//        }
//        public void setUsername(String username) {
//            this.username = username;
//        }
//        public String getPassword() {
//            return password;
//        }
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }
//
//    public static class Player {
//        private String id;
//        private String username;
//        private String password;
//        private int x;
//        private int y;
//        private int health;
//        private int score;
//
//        // Getters and Setters
//        public String getId() {
//            return id;
//        }
//        public void setId(String id) {
//            this.id = id;
//        }
//        public String getUsername() {
//            return username;
//        }
//        public void setUsername(String username) {
//            this.username = username;
//        }
//        public String getPassword() {
//            return password;
//        }
//        public void setPassword(String password) {
//            this.password = password;
//        }
//        public int getX() {
//            return x;
//        }
//        public void setX(int x) {
//            this.x = x;
//        }
//        public int getY() {
//            return y;
//        }
//        public void setY(int y) {
//            this.y = y;
//        }
//        public int getHealth() {
//            return health;
//        }
//        public void setHealth(int health) {
//            this.health = health;
//        }
//        public int getScore() {
//            return score;
//        }
//        public void setScore(int score) {
//            this.score = score;
//        }
//    }
//}
