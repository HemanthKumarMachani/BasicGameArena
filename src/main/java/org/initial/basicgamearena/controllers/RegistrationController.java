package org.initial.basicgamearena.controllers;

import jakarta.validation.Valid;
import org.initial.basicgamearena.dto.PlayerRequestDTO;
import org.initial.basicgamearena.dto.PlayerResponseDTO;
import org.initial.basicgamearena.model.Player;
import org.initial.basicgamearena.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/player")
public class RegistrationController {

    private final PlayerService playerService;

    public RegistrationController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/register")
    public ResponseEntity<PlayerResponseDTO> registerPlayer(@Valid @RequestBody PlayerRequestDTO request) {
        Player player = new Player();
        player.setId(UUID.randomUUID().toString());
        player.setUsername(request.getUsername());
        player.setPassword(request.getPassword());
        player.setX(0);
        player.setY(0);
        player.setHealth(100);
        player.setScore(0);

        playerService.registerPlayer(player);

        PlayerResponseDTO response = new PlayerResponseDTO();
        response.setId(player.getId());
        response.setX(player.getX());
        response.setY(player.getY());
        response.setHealth(player.getHealth());
        response.setScore(player.getScore());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}