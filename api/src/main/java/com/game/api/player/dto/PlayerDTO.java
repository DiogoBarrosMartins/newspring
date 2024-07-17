package com.game.api.player.dto;

import com.game.api.village.dto.VillageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<VillageDTO> villages;
}
