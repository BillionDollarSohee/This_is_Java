package org.example.collection;

import java.util.ArrayList;
import java.util.List;

/*
제너릭
제너릭은 필수기능으로 C#, Java 둘 다 가지고 있다.

1. 타입을 처음부터 감게
2. 타입 안정성 (타입 강제)
3. 강제 형변환 필요없다.

자주 사용하는 타입인자 <T>type parameter <E>

 */
class MyGeneric<T> {
    T obj;

    void add(T obj) {
        this.obj = obj;
    }

    T get() {
        return this.obj;
    }
}

class Person {

}
public class Ex_04_Generic {
    public static void main(String[] args) {
        MyGeneric<String> myGeneric = new MyGeneric<>();
        myGeneric.add("짜잔");
        myGeneric.get();

        List list = new ArrayList();
        list.add(0);
        list.add("String");
        list.add(myGeneric);

        for (Object e : list) {
            if(e instanceof MyGeneric) {
                MyGeneric g = (MyGeneric) e;
                System.out.println(g.get());
            } else if (e instanceof String) {
                System.out.println(e);
            } else if (e instanceof Integer) {
                System.out.println(e);
            }
        }

    }
}
