package com.pavlyshyn.pair;

public class TupleStringGenerator {
    private final TupleString[] countryCapital = {
            new TupleString("Ukraine", "Kyiv"),
            new TupleString("Georgia", "Tbilisi"),
            new TupleString("Poland", "Warsaw"),
            new TupleString("England", "London"),
            new TupleString("Czech Republic","Prague"),
            new TupleString("U.S.A.", "Washington"),
            new TupleString("Brazil", "Brazilia"),
            new TupleString("Ireland", "Dublin"),
            new TupleString("N. Ireland", "Belfast"),

    };
    private int next = 0;

    public TupleString next(){
        return countryCapital[(next++)%countryCapital.length];
    }
}
