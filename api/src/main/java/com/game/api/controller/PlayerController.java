package com.game.api.controller;

import com.game.api.dto.PlayerDTO;
import com.game.api.entity.Player;
import com.game.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayer(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping()
    public PlayerDTO createPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.createPlayer(playerDTO);
    }

    @PatchMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody String firstName, @RequestParam String lastName, @RequestParam String email) {
        return playerService.updatePlayer(id, firstName, lastName, email);
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
