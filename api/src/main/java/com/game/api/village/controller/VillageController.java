package com.game.api.village.controller;

import com.game.api.village.dto.VillageDTO;
import com.game.api.village.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/villages")
public class VillageController {

    @Autowired
    private VillageService villageService;

    @GetMapping
    public List<VillageDTO> getVillages() {
        return villageService.getAllVillages();
    }

    @GetMapping("/{id}")
    public Optional<VillageDTO> getVillage(@PathVariable Long id) {
        return villageService.getVillageById(id);
    }

    @PostMapping()
    public VillageDTO createVillage(@RequestBody VillageDTO villageDTO) {
        return villageService.createVillage(villageDTO);
    }

    @PatchMapping("/{id}")
    public VillageDTO updateVillage(@PathVariable Long id, @RequestBody VillageDTO villageDTO) {
        return villageService.updateVillage(id, villageDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteVillage(@PathVariable Long id) {
        try {
            villageService.deleteVillage(id);
            return "Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
