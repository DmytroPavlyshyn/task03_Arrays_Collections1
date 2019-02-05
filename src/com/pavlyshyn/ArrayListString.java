package com.pavlyshyn;

import java.util.ArrayList;
import java.util.List;

public class ArrayListString {
    private final static int DEFAULT_INITIAL_CAPACITY = 11;
    private String[] array;
    private int minCapacity;
    private int capacity;

    public ArrayListString() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayListString(int capacity) {
        this.capacity = capacity;
        array = new String[capacity];
        minCapacity = 0;
    }

    public ArrayListString(String[] array) {
        this.array = array;
        this.capacity = this.minCapacity = array.length;
    }

    void add(String s){
        if(minCapacity==capacity){
            reallocate();
        }
        array[minCapacity++] = s;
    }
    String get(int index){
        return array[index];
    }

    @SuppressWarnings("unchecked")
    private void reallocate(){
        int newSize = array.length + (array.length>> 1);
        int oldSize = array.length;
        String[] temp = new String[newSize];

        for(int i = 0; i<oldSize; i++)
            temp[i] = array[i];

        array = temp;
        capacity = array.length;
    }
    public static void test(int numberOfIterations){
        ArrayListString arrayListString = new ArrayListString();
        List<String> strings = new ArrayList<>();
        long start, end;
        System.out.println("Number of iterations: " + numberOfIterations );
        start = System.nanoTime();
        for(int i = 0; i< numberOfIterations; i++){
            arrayListString.add(Integer.toString(i));
        }
        end = System.nanoTime() - start;
        System.out.println("ArrayListString add " + end);
        start = System.nanoTime();
        for(int i = 0; i< numberOfIterations; i++){
            arrayListString.get(i);
        }
        end = System.nanoTime() - start;
        System.out.println("ArrayListString get " + end);
        start = System.nanoTime();
        for(int i = 0; i< numberOfIterations; i++){
            strings.add(Integer.toString(i));
        }
        end = System.nanoTime() - start;
        System.out.println("ArrayList add " + end );
        start = System.nanoTime();
        for(int i = 0; i< numberOfIterations; i++){
            strings.get(i);
        }
        end = System.nanoTime() - start;
        System.out.println("ArrayList get " + end );

    }
    public static void main(String[] args) {
      test(100);
      test(1000);
      test(100000);
      test(1000000);
      test(10000000);

    }
}
