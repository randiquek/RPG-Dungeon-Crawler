package com.myprojects.dungeonscape.controller;

import com.myprojects.dungeonscape.data.model.Player;
import com.myprojects.dungeonscape.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping()
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable UUID id) {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable UUID id, @RequestBody Player updatedPlayer) {
        updatedPlayer.setPlayerId(id);
        return playerService.updatePlayer(updatedPlayer);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable UUID id) {
        playerService.deletePlayer(id);
    }
}
