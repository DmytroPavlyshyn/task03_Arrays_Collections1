package com.pavlyshyn.battle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpaceShip {
    List<? extends Droid> droids;

    public SpaceShip(List<? extends Droid> droids) {
        this.droids = droids;
    }

    public List<? extends Droid> getDroids() {
        return droids;
    }

    public void setDroids(List<? extends Droid> droids) {
        this.droids = droids;
    }

    public static void main(String[] args) {
        Droid droid = new Droid("Citripio", 1200);
        Droid battleDroid = new BattleDroid("R2D2",3000,4000);
        ArrayList<Droid> droids = new ArrayList<>(Arrays.asList(droid,battleDroid));
        SpaceShip droidSpaceShip = new SpaceShip(droids);
        SpaceShip battleDroidSpaceShip = new SpaceShip(Arrays.asList(battleDroid));
        System.out.println(droidSpaceShip.getDroids());
        System.out.println(battleDroidSpaceShip.getDroids());

    }
}
