package com.pavlyshyn.pair;

import com.pavlyshyn.pair.TupleString;

import java.util.Comparator;

public class SecondStringComparator implements Comparator<TupleString> {
    @Override
    public int compare(TupleString o1, TupleString o2) {
        return o1.getS2().compareTo(o2.getS2());
    }
}
