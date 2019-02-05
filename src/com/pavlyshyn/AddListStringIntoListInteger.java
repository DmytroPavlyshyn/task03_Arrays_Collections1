package com.pavlyshyn;

import java.util.ArrayList;
import java.util.List;

public class AddListStringIntoListInteger {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        List list = integers;
        list.add("Hello");
        //int i = integers.get(0); java.lang.ClassCastException
        String s =  String.class.cast(integers.get(0));
        System.out.println(s);
    }
}
