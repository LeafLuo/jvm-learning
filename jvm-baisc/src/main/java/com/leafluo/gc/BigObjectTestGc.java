package com.leafluo.gc;

public class BigObjectTestGc {
    /**
     * -XX:+[ -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     * @param args
     */
    private static final int _1MB = 1024 * 1024;


    public static void main(String[] args) {

//        byte[] allocation;
//
//        allocation = new byte[4 * _1MB];
//        testTenuringThreshold();
//
//         testTenuringThreshold2();
        testHandlePromotion();
    }

    /**
     * -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {
        byte[] allocation1,allocation2,allocation3;
        allocation1 = new byte[_1MB/4];
        allocation2 = new byte[4 * _1MB];

         allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];

    }

    @SuppressWarnings("unused")
    public static void testTenuringThreshold2() {
        byte[] allocation1,allocation2,allocation3, allocation4;
        allocation1 = new byte[_1MB/4];

        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];

    }

    public static void  testHandlePromotion() {
        byte[] allocation1,allocation2,allocation3, allocation4, allocation5, allocation6,
        allocation7;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;

        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];

    }
}
