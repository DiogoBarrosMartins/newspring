package com.game.api.player.controller;

import com.game.api.player.entity.Player;
import com.game.api.player.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable Long id) {
        return playerRepository.findById(id).get();
    }

    @PostMapping()
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PatchMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        Player existingPlayer = playerRepository.findById(id).get();
        existingPlayer.setFirstName(player.getFirstName());
        existingPlayer.setLastName(player.getLastName());
        existingPlayer.setEmail(player.getEmail());
        return playerRepository.save(existingPlayer);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        try {
            playerRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}

