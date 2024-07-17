package com.game.api.player.controller;

import com.game.api.player.dto.PlayerDTO;
import com.game.api.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<PlayerDTO> getPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping()
    public PlayerDTO createPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @PatchMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        return playerService.updatePlayer(id, playerDTO);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        try {
            playerService.deletePlayer(id);
            return "Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
