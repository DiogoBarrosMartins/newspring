package com.game.api.village.service;

import com.game.api.village.dto.VillageDTO;
import com.game.api.village.entity.Village;
import com.game.api.village.repository.VillageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;

    public List<VillageDTO> getAllVillages() {
        return villageRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<VillageDTO> getVillageById(Long id) {
        return villageRepository.findById(id).map(this::convertToDto);
    }

    public VillageDTO createVillage(VillageDTO villageDTO) {
        Village village = convertToEntity(villageDTO);
        Village savedVillage = villageRepository.save(village);
        return convertToDto(savedVillage);
    }

    public VillageDTO updateVillage(Long id, VillageDTO villageDTO) {
        Village village = villageRepository.findById(id).orElseThrow(() -> new RuntimeException("Village not found"));
        village.setName(villageDTO.getName());
        return convertToDto(villageRepository.save(village));
    }

    public void deleteVillage(Long id) {
        villageRepository.deleteById(id);
    }

    public VillageDTO convertToDto(Village village) {
        return new VillageDTO(village.getId(), village.getName());
    }

    public Village convertToEntity(VillageDTO villageDTO) {
        Village village = new Village();
        village.setId(villageDTO.getId());
        village.setName(villageDTO.getName());
        return village;
    }

    public Village createNewVillage(String villageName) {
        Village village = new Village();
        village.setName(villageName);
        return villageRepository.save(village);
    }
}
