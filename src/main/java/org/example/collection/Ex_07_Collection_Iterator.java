package org.example.collection;
/*
컬렉션 프레임 워크

다수의 데이터를 다루는 방법을 표준화하여 인터페이스로 다양한 기능을 구현한 클래스로
JAVA API -> 인터페이스 -> 클래스

Iterator 인터페이스
나열된 자원에 대애 순차적으로 접근해서 값의 유무를 판단하고
값을 리턴하는 표준을 정의

ArrayList와 LinkedList -> for,while로 가능하지만 처리방식을 표준화한 것이
이터레이터이고 이터레이터는 어레이리스트가 구현(implement)하고 있다.

haxNext(), Next(), remove() 라는 추상클래스를
ArrayList가 구체화해서 구현해서 가지고 있다. 내부적으로 while문이 있음
for문을 안쓰는 것이 아니라
표준화된 데이터 다루는 방식으로 합시다. 라고 한다면 이터레이터를 사용하라는 말
 */


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex_07_Collection_Iterator {
    public static void main(String[] atgs) {
        List list = new ArrayList();

        list.add(100);
        list.add(200);
        list.add(300);

        // 이터레이터 호출 시 함수안에서 이터레이스의 인터페이스를 구현하고있는
        // 객체의 주소값을 리턴해 준다.
        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        List<Integer> IntList= new ArrayList<>();

        IntList.add(400);
        IntList.add(500);
        IntList.add(600);

        ListIterator<Integer> e = IntList.listIterator();

        // 순방향
        while (e.hasNext()) {
            int num = e.next();
            if(num % 2 == 0) {
                e.remove();
            }
        }

        //역방향
        while(e.hasPrevious()) {
            System.out.println(e.previous());
        }


    }
}
