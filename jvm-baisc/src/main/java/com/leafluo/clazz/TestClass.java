package com.leafluo.clazz;


public class TestClass {

    private int m;

    public int inc() {
        int x;
        try {
            x = 2;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }


}
