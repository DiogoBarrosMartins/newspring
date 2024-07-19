package com.game.api.village.service;


import com.game.api.village.repository.VillageRepository;
import com.game.api.village.entity.Village;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VillageService {

    @Autowired
    private VillageRepository villageRepository;


    @Transactional(readOnly = true)
    public List<Village> getAll() {
        return villageRepository.findAll();
    }
}
