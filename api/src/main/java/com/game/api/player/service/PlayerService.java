package com.game.api.player.service;

import com.game.api.player.dto.PlayerDTO;
import com.game.api.player.entity.Player;
import com.game.api.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<PlayerDTO> getPlayerById(Long id) {
        return playerRepository.findById(id).map(this::convertToDto);
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = convertToEntity(playerDTO);
        return convertToDto(playerRepository.save(player));
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setEmail(playerDTO.getEmail());
        return convertToDto(playerRepository.save(player));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    private PlayerDTO convertToDto(Player player) {
        return new PlayerDTO( player.getFirstName(), player.getLastName(), player.getEmail());
    }

    private Player convertToEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setEmail(playerDTO.getEmail());
        return player;
    }
}
