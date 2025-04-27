package org.initial.basicgamearena.model;

public class Player {
    private String id;
    private int x =0;
    private int y =0;
    private int health = 100;
    private int score =0;
    public Player(String id, int x, int y, int health, int score) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.health = health;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

