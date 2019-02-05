package com.pavlyshyn;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        java.util.PriorityQueue priorityQueue = new java.util.PriorityQueue();
        for(int i=0; i<10; i++){
            priorityQueue.add(i);
        }
        for(int i=0; i<10; i++){
            priorityQueue.add(i);
        }
        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }
}
