package com.game.api.village.service;


import com.game.api.village.dto.VillageDTO;
import com.game.api.village.entity.Village;
import com.game.api.village.dto.VillageMapper;
import com.game.api.village.repository.VillageRepository;
import com.game.api.login.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;

    public List<VillageDTO> getAllVillages() {
        return villageRepository.findAll().stream()
                .map(VillageMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public VillageDTO getVillageById(Long id) {
        return villageRepository.findById(id)
                .map(VillageMapper::entityToDto)
                .orElse(null);
    }


    public void deleteVillage(Long id) {
        villageRepository.deleteById(id);
    }

    public Village createVillage(String name, Account account) {
        Village village = new Village();
        village.setName(name);
        village.setAccount(account);
        return villageRepository.save(village);
    }


}
