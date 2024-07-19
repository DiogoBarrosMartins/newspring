package com.game.api.village.dto;

import com.game.api.village.entity.Village;

public class VillageMapper {

    public static VillageDTO entityToDto(Village village) {
        if (village == null) {
            return null;
        }
        return new VillageDTO(
                village.getId(),
                village.getName(),
                village.getAccount() != null ? village.getAccount().getId() : null
        );
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
