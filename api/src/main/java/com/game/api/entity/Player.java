package com.game.api.entity;

import com.game.api.dto.PlayerDTO;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="email",nullable = false)
    private String email;

    @ElementCollection
    private List<Long> villageIds;


    public List<Long> getVillageIds() {
        return villageIds;
    }

    public void setVillageIds(List<Long> villageIds) {
        this.villageIds = villageIds;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

public PlayerDTO toDto(Player this){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setFirstName(this.getFirstName());
        playerDTO.setLastName(this.getLastName());
        playerDTO.setEmail(this.getEmail());
        playerDTO.setVillageIds(this.getVillageIds());
        return playerDTO;
}


}
