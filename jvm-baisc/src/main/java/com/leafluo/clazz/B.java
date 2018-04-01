package com.leafluo.clazz;

public class B extends Foo{

    public static final String abc = "b";


    @Override
    public void test() {
        super.test();
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(B.abc);
        Foo foo = new Foo();
        System.out.println(foo.abc);
    }
}
