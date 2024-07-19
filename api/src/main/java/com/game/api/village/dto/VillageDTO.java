package com.game.api.village.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VillageDTO {

    private Long id;
    private String name;
    private Long accountId;

}
