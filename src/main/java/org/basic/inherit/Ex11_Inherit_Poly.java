package org.basic.inherit;

class Pbase {
    int p = 100;
}

class Cbase extends Pbase {
    int c = 200;
}

class Dbase extends Pbase {

}

public class Ex11_Inherit_Poly {
    public static void main(String[] args) {
        Cbase cbase = new Cbase();
        System.out.println(cbase.toString()); // Object의 toString() 상속

        // 업캐스팅 (자식 → 부모) : 항상 안전
        Pbase pbase = cbase;
        // pbase는 부모 타입이므로 부모 멤버(p)만 접근 가능
        // 단, 재정의된 메서드가 있다면 자식의 것이 호출됨

        Dbase dbase = new Dbase();
        pbase = dbase; // 또 다른 업캐스팅 (OK)

        // 다운캐스팅 (부모 → 자식) : 실제 객체 타입을 확인해야 안전
        if (pbase instanceof Cbase) {
            Cbase ccc = (Cbase) pbase; // 안전한 다운캐스팅
            System.out.println("다운캐스팅 성공: " + ccc.c);
        } else {
            System.out.println("pbase는 Cbase 타입이 아님 → 다운캐스팅 불가");
        }
    }
}
