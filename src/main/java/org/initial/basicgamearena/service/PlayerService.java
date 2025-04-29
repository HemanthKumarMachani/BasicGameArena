package org.initial.basicgamearena.service;

import org.initial.basicgamearena.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PlayerService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);
    private final Map<String, Player> players = new ConcurrentHashMap<>();

    public Player registerPlayer(Player player) {
        players.put(player.getId(), player);
        logger.info("New player registered: {}" , player);
        return player;
    }

    public Player getPlayer(String id) {
        return players.get(id);
    }

    public Map<String, Player> getAllPlayers() {
        return players;
    }

    public void removePlayer(String id) {
        players.remove(id);
    }
}