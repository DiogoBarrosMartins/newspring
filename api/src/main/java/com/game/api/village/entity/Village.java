package com.game.api.village.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "villages")
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String name;

    @Column( nullable = false)
    private String playerId;


    public Village(Long id, String name, String playerId) {
        this.id = id;
        this.name = name;
        this.playerId = playerId;
    }

    public Village() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
