package com.game.api.village.controller;


import com.game.api.login.entity.Account;
import com.game.api.login.service.AccountService;
import com.game.api.village.entity.Village;
import com.game.api.village.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/villages")
public class VillageController {

    @Autowired
    private VillageService villageService;


    @GetMapping
    public List<Village> getVillages() {
        return villageService.getAll();
    }

}
