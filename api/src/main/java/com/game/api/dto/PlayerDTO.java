package com.game.api.dto;

import com.game.api.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class PlayerDTO {

    private String firstName;
    private String lastName;
    private String email;
    private List<Long> villageIds= new ArrayList<>();

    public PlayerDTO(String firstName, String lastName, String email, List<Long> villageIds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.villageIds = villageIds;
    }

    public PlayerDTO() {

    }

    public PlayerDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getVillageIds() {
        return villageIds;
    }

    public void setVillageIds(List<Long> villageIds) {
        this.villageIds = villageIds;
    }
    public Player toEntity (PlayerDTO playerDTO){
        Player player = new Player();
        player.setFirstName(playerDTO.getFirstName());
        player.setLastName(playerDTO.getLastName());
        player.setEmail(playerDTO.getEmail());
        player.setVillageIds(playerDTO.getVillageIds());
        return player;
    }
}
