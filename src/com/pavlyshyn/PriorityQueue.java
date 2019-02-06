package com.pavlyshyn;

import java.util.*;

public class PriorityQueue <E>  {
    private final static int DEFAULT_INITIAL_CAPACITY = 11;
    private E[] es;
    private int minCapacity;
    private int capacity;
    private Comparator comparator;

    public PriorityQueue(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY,comparator);
    }

    @SuppressWarnings(value = "unchecked")
    public PriorityQueue(int capacity, Comparator comparator) {
        this.capacity = capacity;
        this.es = (E[]) new Object[capacity];
        this.comparator = comparator;
    }

    @SuppressWarnings(value = "unchecked")
    void offer(E a){
        if(minCapacity ==capacity){
            reallocate(es);

        }
        int i;
        if(minCapacity ==0){
            es[minCapacity++] = a;

        }
        else {
            for (i = minCapacity -1; i>=0; i--) {
                if (comparator.compare(a, es[i]) > 0) {
                    es[i + 1] = es[i];
                }
                else{
                    break;
                }
            }
            es[i+1] = a;
            minCapacity++;
        }
    }

    public E poll() {
        if(minCapacity == 0) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        return es[--minCapacity];
    }

    @SuppressWarnings("unchecked")
    private void reallocate(E[] array){
        int newSize = es.length + (es.length>> 1);
        int oldSize = es.length;
        E[] temp = (E[]) new Object[newSize];

        for(int i = 0; i<oldSize; i++)
            temp[i] = es[i];

        es = temp;
    }

    public boolean isEmpty(){
        return minCapacity==0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int priority = minCapacity;
        stringBuffer.append("[");
        for(int i = 0; i< minCapacity; i++){
            stringBuffer.append(priority--);
            stringBuffer.append(" : ");
            stringBuffer.append(es[i]);
            stringBuffer.append(", ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(Integer::compareTo);
        integerPriorityQueue.offer(12);
        integerPriorityQueue.offer(54);
        integerPriorityQueue.offer(11);
        integerPriorityQueue.offer(12);
        integerPriorityQueue.offer(33);
        System.out.println(integerPriorityQueue);
        while (!integerPriorityQueue.isEmpty()){
            System.out.println(integerPriorityQueue.poll());
        }
    }


}
