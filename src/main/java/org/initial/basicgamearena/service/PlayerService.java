package org.initial.basicgamearena.service;

import org.initial.basicgamearena.model.Player;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PlayerService {

    private final Map<String, Player> players = new ConcurrentHashMap<>();

    public Player registerPlayer(Player player) {
        players.put(player.getId(), player);
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