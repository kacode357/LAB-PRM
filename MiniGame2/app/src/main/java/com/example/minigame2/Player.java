package com.example.minigame2;

import java.io.Serializable;

public class Player implements Serializable {

    private String id;
    private String name;
    private String dogBreed;
    private String win;

    // Constructor
    public Player(String id, String name, String dogBreed, String win) {
        this.id = id;
        this.name = name;
        this.dogBreed = dogBreed;
        this.win = win;
    }

    // Getter and Setter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public String getWin() {
        return win;
    }
}
