package com.pavlyshyn.battle;

public class Droid {
    private String name;
    private int energyLevel;

    public Droid(String name, int energyLevel) {
        this.name = name;
        this.energyLevel = energyLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", energyLevel=" + energyLevel +
                '}';
    }
}
