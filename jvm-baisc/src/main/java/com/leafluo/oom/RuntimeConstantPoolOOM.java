package com.leafluo.oom;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;

        while (true) {
            list.add(String.valueOf(i++).intern());
        }

//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
//
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);

//        String str3 = "计算机软件";
//        System.out.println(str3 == str2);
//        String str5 = new String("计算机软件");
//        String str4 = "计算机软件";

//        System.out.println(str3 == str4);

//        System.out.println(str4 == str5);
    }
}
