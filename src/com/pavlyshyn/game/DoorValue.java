package com.pavlyshyn.game;

public class DoorValue {
    boolean type; // true - magic artifact, false - monster
    int score;

    public DoorValue(boolean type, int score) {
        this.type = type;
        this.score = score;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "\n[" + (type?"artifact":"monster") +
                " score=" + score +
                "]\n";
    }
}
