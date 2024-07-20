package com.game.api.village.controller;

import com.game.api.village.dto.VillageDTO;
import com.game.api.village.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villages")
public class VillageController {

    @Autowired
    private VillageService villageService;

    @GetMapping
    public List<VillageDTO> getAllVillages() {
        return villageService.getAllVillages();
    }

    @GetMapping("/{id}")
    public VillageDTO getVillageById(@PathVariable Long id) {
        return villageService.getVillageById(id);
    }



    @DeleteMapping("/{id}")
    public void deleteVillage(@PathVariable Long id) {
        villageService.deleteVillage(id);
    }
}
