package org.initial.basicgamearena.controllers;
import org.initial.basicgamearena.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api")
public class GameController {

    private final Map<String, Player> players = new ConcurrentHashMap<>();

    @PostMapping("/register")
    public Player registerPlayer() {
        String id = UUID.randomUUID().toString();
        Player player = new Player(id, 0, 0, 100, 0);
        players.put(id, player);
        return player;
    }

    @PostMapping("/move/{id}")
    public ResponseEntity<?> movePlayer(@PathVariable String id, @RequestParam int x, @RequestParam int y) {
        Player player = players.get(id);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found!");
        }
        player.setX(player.getX() + x);
        player.setY(player.getY() + y);
        return ResponseEntity.ok(player);
    }

    @PostMapping("/attack/{attackerId}/{targetId}")
    public String attackPlayer(@PathVariable String attackerId, @PathVariable String targetId) {
        Player attacker = players.get(attackerId);
        Player target = players.get(targetId);
        if (attacker == null || target == null) {
            return "One of the players does not exist!";
        }
        target.setHealth(target.getHealth() - 10);
        if (target.getHealth() <= 0) {
            attacker.setScore(attacker.getScore() + 100);
            players.remove(targetId);
            return "Target eliminated!";
        }
        return "Attack successful!";
    }

    @GetMapping("/state/{id}")
    public Player getPlayerState(@PathVariable String id) {
        return players.get(id);
    }
}