package com.game.api.player.service;

import com.game.api.player.dto.PlayerDTO;
import com.game.api.player.entity.Player;
import com.game.api.player.repository.PlayerRepository;
import com.game.api.village.dto.VillageDTO;
import com.game.api.village.entity.Village;
import com.game.api.village.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private VillageService villageService;

    public List<PlayerDTO> getAllPlayers() {
        return playerRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<PlayerDTO> getPlayerById(Long id) {
        return playerRepository.findById(id).map(this::convertToDto);
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = convertToEntity(playerDTO);

        // Create a new village and associate it with the player
        Village newVillage = villageService.createNewVillage("New Village");
        player.setVillages(List.of(newVillage));

        Player savedPlayer = playerRepository.save(player);
        return convertToDto(savedPlayer);
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setEmail(playerDTO.getEmail());
        player.setVillages(playerDTO.getVillages().stream().map(villageService::convertToEntity).collect(Collectors.toList()));
        return convertToDto(playerRepository.save(player));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    private PlayerDTO convertToDto(Player player) {
        List<VillageDTO> villageDTOs = player.getVillages().stream().map(villageService::convertToDto).collect(Collectors.toList());
        return new PlayerDTO(player.getId(), player.getFirstName(), player.getLastName(), player.getEmail(), villageDTOs);
    }

    private Player convertToEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setId(playerDTO.getId());
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setEmail(playerDTO.getEmail());
        player.setVillages(playerDTO.getVillages().stream().map(villageService::convertToEntity).collect(Collectors.toList()));
        return player;
    }
}
