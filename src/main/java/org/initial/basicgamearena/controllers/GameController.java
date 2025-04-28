package org.initial.basicgamearena.controllers;

import org.initial.basicgamearena.model.Player;
import org.initial.basicgamearena.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private final PlayerService playerService;

    public GameController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/move/{id}")
    public ResponseEntity<?> movePlayer(@PathVariable String id, @RequestParam int x, @RequestParam int y) {
        Player player = playerService.getPlayer(id);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found!");
        }
        player.setX(player.getX() + x);
        player.setY(player.getY() + y);
        return ResponseEntity.ok(player);
    }

    @PostMapping("/attack/{attackerId}/{targetId}")
    public ResponseEntity<String> attackPlayer(@PathVariable String attackerId, @PathVariable String targetId) {
        Player attacker = playerService.getPlayer(attackerId);
        Player target = playerService.getPlayer(targetId);

        if (attacker == null || target == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("One of the players does not exist!");
        }

        target.setHealth(target.getHealth() - 10);
        if (target.getHealth() <= 0) {
            attacker.setScore(attacker.getScore() + 100);
            playerService.removePlayer(targetId);
            return ResponseEntity.ok("Target eliminated!");
        }
        return ResponseEntity.ok("Attack successful!");
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<?> getPlayerState(@PathVariable String id) {
        Player player = playerService.getPlayer(id);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found!");
        }
        return ResponseEntity.ok(player);
    }
}