package com.game.api.login.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String username;

    @Column( nullable = false)
    private String password;

    @Column( nullable = false)
    private String tribe;



    public Account(Long id, String username, String password,   String tribe) {
        this.id = id;
        this.username = username;
        this.password = password;

        this.tribe = tribe;
    }

    public Account() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
