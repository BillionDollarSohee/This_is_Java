package org.Lambda;


@FunctionalInterface
interface MyFun{
    void method(int x);
}

@FunctionalInterface
interface MyFun2{
    int method(int x, int y);
}

public class Ex04_Lambda {
    public static void main(String[] args) {

        MyFun my = new MyFun() {
            @Override
            public void method(int x) {
                System.out.println("param x : " + x );
            }
        };
        my.method(100);

        MyFun my2 = (x) -> System.out.println("param x : " + x );
        my2.method(200);

        MyFun2 myFun1 = (x, y) -> { int result = x + y; return result; };
        MyFun2 myFun2 = (x, y) -> x + y;
        int data = myFun2.method(3, 5);

    }
}
