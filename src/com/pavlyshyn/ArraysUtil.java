package com.pavlyshyn;

import java.util.Arrays;

public class ArraysUtil {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,3,4,5},new int[]{4,5,6,7})));
        System.out.println(Arrays.toString(copyOfRange(new int[]{0,1,2,3,4,5,6},0,5)));
        System.out.println(Arrays.toString(union(new int[]{1,2,3,4,5},new int[]{4,5,6,7})));
        System.out.println(Arrays.toString(except(new int[]{1,2,3,4,5,8},new int[]{4,5,6,7})));
        int[] a = new int[]{1,1,1,2,3,4,5,5,5};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(removeEqualSequence(a)));
    }

    public static int[] intersect(int[] a, int[] b){
        int size = a.length > b.length ? b.length:a.length;
        int[] result = new int[size];
        int index = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++) {
                if ((a[i] == b[j] )&&!consists(result, a[i])) {
                    result[index++] = a[i];
                }
            }
        }
        if(index<size){
            result = copyOfRange(result,0,index);
        }
        return result;
    }
    public static int[] except(int[] a, int[] b){
        int size = a.length;
        int[] result = new int[size];
        int[] temp = union(b,intersect(a,b));
        int index = 0;
        for(int i: a){
            if(!consists(temp,i)){
                result[index++] = i;
            }
        }
        return copyOfRange(result,0,index);
    }

    public static boolean consists(int[] arr, int el){
        for(int i:arr){
            if(i ==el){
                return true;
            }
        }
        return false;
    }
    public static int[] removeMoreThanN(int[] a, int N){
        int size = a.length;
        int[] result = new int[size];
        int index = 0;
        for(int i = 0; i<a.length; i++){
            if(!(count(a,a[i])>N)){
               result[index++] = a[i];
            }
        }
        return copyOfRange(result,0,index);
    }

    public static int[] removeEqualSequence(int [] a){
        int[] result = copyOfRange(a,0,a.length);
        int capacity = a.length;
        for(int i = 0; i< capacity; i++){
            if(result[i] == result[i+1]){
                for(int j = i; j < capacity-1; j++){
                    result[j] = result[j+1];
                }
                i--;
                capacity--;
            }
        }
        return copyOfRange(result,0,capacity+1);
    }
    public static int[] removeMoreThanTwo(int[] a){
        return removeMoreThanN(a,2);
    }
    public static int count(int[] a, int el){
        int counter = 0;
        for(int i:a){
            if(i == el){
                counter++;
            }
        }
        return counter;
    }
    public static int[] union(int[] a, int[] b){
        int size = a.length+b.length;
        int[] result = new int[size];
        int index = 0;
        for(int i : a){
            if(!consists(result,i)) {
                result[index++] = i;
            }
        }
        for(int i : b){
            if(!consists(result,i)) {
                result[index++] = i;
            }
        }

        return copyOfRange(result,0,index);
    }
    public static int[] copyOfRange(int[] array, int from, int to){
        int newLength = to - from;
        if (newLength < 0)
            throw new IllegalArgumentException(from + " > " + to);
        int[] result = new int[newLength];

        for(int i = from; i<to; i++){
            result[i] = array[i];
        }
        return result;
    }

}
