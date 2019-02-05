package com.pavlyshyn.pair;

import java.util.Objects;

public class TupleString implements Comparable<TupleString>{
    private String s1;
    private String s2;

    public TupleString(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    @Override
    public int compareTo(TupleString o) {
        return s1.compareTo(o.s2);
    }

    @Override
    public String toString() {
        return "[" +
                "'" + s1 + '\'' +
                "--'" + s2 + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TupleString)) return false;
        TupleString that = (TupleString) o;
        return Objects.equals(getS1(), that.getS1()) &&
                Objects.equals(getS2(), that.getS2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getS1(), getS2());
    }
}
