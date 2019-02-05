package com.pavlyshyn.game;



public class Game {
    int score = 25;
    final int DEFAULT_DOOR_NUMBER = 10;
    DoorValue[] doors = new DoorValue[DEFAULT_DOOR_NUMBER];
    public void generateDoors(){
        DoorGenerator doorGenerator = new DoorGenerator();
        for(int i = 0; i<doors.length; i++ ){
            doors[i] = doorGenerator.next();
        }
    }
    public void printDoors(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--------------\n");
        for(int i=0; i< doors.length; i++) {
            stringBuilder.append(String.format("|%8s|%3d|\n", (doors[i].type ? "artifact" : "monster"),doors[i].score));
            if(i+1!=doors.length) {
                stringBuilder.append("--------------\n");
            }

        }
        stringBuilder.append("--------------\n");
        System.out.println(stringBuilder.toString());

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.generateDoors();
        game.printDoors();
    }
}
