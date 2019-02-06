package com.pavlyshyn.game;


import java.util.*;
import static java.util.Map.Entry;
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
        stringBuilder.append("\033[34m-----------------\n");
        for(int i=0; i< doors.length; i++) {
            if(doors[i]!=null) {
                stringBuilder.append(String.format("|%2d|%8s|%3d|\n", i, (doors[i].isType() ? "artifact" : "monster"), doors[i].score));
            }
            if(i+1!=doors.length) {
                stringBuilder.append("-----------------\n");
            }

        }
        stringBuilder.append("-----------------\n\033[0m");
        System.out.println(stringBuilder.toString());

    }
    public int countDeath(){
        return counter(0,0,score);
    }

    private int counter(int start, int counter, int heroScore){
        if(counter == doors.length){
            return -1;
        }
        if(!doors[start].isType()){
            if(heroScore - doors[start].getScore()<0){
                return ++counter;
            }

        }
        return counter(++start,counter,heroScore);
    }
    public int[] winPath(){
        LinkedHashMap<Integer,DoorValue> order = new LinkedHashMap<>();
        int i = 0;
        for(DoorValue doorValue: doors){
            order.put(i++,doorValue);
        }
        List<Entry<Integer,DoorValue>> entries = new ArrayList<>(order.entrySet());
        entries.sort((a,b)->{
            if(a.getValue().isType()){
                return -1;
            }
            if(a.getValue().isType()==b.getValue().isType()) {
                return 0;
            }
            return 1;
        });
        if(willDie(entries)){
            return null;
        }
        int[] winPath = new int[entries.size()];
        int intdex = 0;
        for(Entry<Integer,DoorValue> entry : entries){
            winPath[intdex++] = entry.getKey();
        }
        return winPath;
    }

    private boolean willDie(List<Entry<Integer,DoorValue>> entries){
        int sum = 0;
        for(Entry<Integer,DoorValue> entry:entries){
            if(entry.getValue().isType()){
                sum +=entry.getValue().score;
            }
            else {
                sum -=entry.getValue().score;
            }
        }
        return sum<0;
    }
    public void play(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printDoors();
            System.out.println("\033[33mChoose door ");
            System.out.println("Your current score: " + score);
            DoorValue door;
            try {
                int doorNumber = scanner.nextInt();
                DoorValue doorValue = doors[doorNumber];
                doors[doorNumber] = null;

                System.out.println("It is " + (doorValue.isType() ? "\033[33martifact +" : "\033[31mmonster -") + doorValue.getScore());
                if (doorValue.isType()) {
                    score += doorValue.getScore();
                } else {
                    score -= doorValue.getScore();
                }
                scanner.nextLine();
                if(doorsOpened() && score>=0){
                    System.out.println("\33[35mYou win");
                    return;
                }
                if(score<0){
                    System.out.println("\033[31mYou loose");
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Incorrect input");
            }

        }
    }
    boolean doorsOpened(){
        int counter = 0;
        for(DoorValue doorValue: doors){
            if(doorValue==null){
                counter++;
            }
        }
        return counter==doors.length;
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.generateDoors();
        game.printDoors();
        System.out.println("\033[31mYou can die on " + game.countDeath() + " number of monsters\033[0m");
        int[] path = game.winPath();
        System.out.println((path==null)?"\033[31mYou loose":"\033[32mWinning path"+Arrays.toString(path));
        game.play();
    }
}
