package com.game.api.village.dto;

import com.game.api.village.entity.Village;

public class VillageMapper {

    public static VillageDTO entityToDto(Village village) {
        if (village == null) {
            return null;
        }

        VillageDTO villageDTO = new VillageDTO();
        villageDTO.setId(village.getId());
        villageDTO.setName(village.getName());
        villageDTO.setAccountId(village.getAccount() != null ? village.getAccount().getId() : null);

        return villageDTO;
    }

    public static Village dtoToEntity(VillageDTO villageDTO) {
        if (villageDTO == null) {
            return null;
        }

        Village village = new Village();
        village.setId(villageDTO.getId());
        village.setName(villageDTO.getName());
        return village;
    }
}
