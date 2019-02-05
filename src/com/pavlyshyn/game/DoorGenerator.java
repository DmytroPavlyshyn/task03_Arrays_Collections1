package com.pavlyshyn.game;

import java.util.Random;

public class DoorGenerator {
    private Random random = new Random(47);
    DoorValue next(){

        if(random.nextBoolean()){
            return new DoorValue(true,10+random.nextInt(71));
        }
        else{
            return new DoorValue(false, 5 + random.nextInt(96));
        }
    }
}
