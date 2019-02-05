package com.pavlyshyn.battle;

public class BattleDroid extends Droid {
    private int maxDamageLevel;

    public BattleDroid(String name, int energyLevel, int maxDamageLevel) {
        super(name, energyLevel);
        this.maxDamageLevel = maxDamageLevel;
    }

    public int getMaxDamageLevel() {
        return maxDamageLevel;
    }

    public void setMaxDamageLevel(int maxDamageLevel) {
        this.maxDamageLevel = maxDamageLevel;
    }

    @Override
    public String toString() {
        return "BattleDroid{" +
                "maxDamageLevel=" + maxDamageLevel +
                "} " + super.toString();
    }
}
