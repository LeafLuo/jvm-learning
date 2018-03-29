package com.leafluo.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());

        }
        list = null;
    }

    /**
     * 死循环
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        }, "testBusyThread");
        thread.start();
    }

    /**
     * 锁等待
     * @param lock
     */
    public static void createLockThread(Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        fillHeap(1000);
//        System.gc();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj = new Object();
        createLockThread(obj);

//        Integer a = 1;
//        Integer b = 1;
//        System.out.println(a == b);
//        Integer c = 128;
//        Integer d = 128;
//        System.out.println(c == d);
    }

    static class SynAddRunable implements Runnable {
        Integer a, b;

        public SynAddRunable(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }

        public static void main(String[] args) {
            for (int i = 0; i < 1000; i++) {
                new Thread(new SynAddRunable(new Integer(1), new Integer(2) )).start();
                new Thread(new SynAddRunable(new Integer(2), new Integer(1) )).start();

            }
        }
    }
}
