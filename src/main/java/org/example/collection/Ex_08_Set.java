package org.example.collection;

import java.util.HashSet;
import java.util.Set;

/*
Set 인터페이스
원안에 들어가세요. 순서를 보장하지 않고, 중복을 허용하지 않는다.

 */
public class Ex_08_Set {
    public static void main (String[] args) {

        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(100);

        boolean b = hs.add(55);
        System.out.println(b);
        b = hs.add(1);
        System.out.println(b);

        System.out.println(hs.toString());

        //로또 차량번호, ID
        HashSet<String> hs2 = new HashSet<String>();
        hs2.add("b");
        hs2.add("a");
        hs2.add("b");
        hs2.add("c");
        hs2.add("g");
        hs2.add("d");
        hs2.add("e");
        hs2.add("h");
        hs2.add("i");
        hs2.add("n");
        hs2.add("l");
        System.out.println(hs2.toString());

        String[] str = {"a","h","v","x","w","k"};
        HashSet<String> hs3 = new HashSet<>();

        for (int i = 0; i < str.length; i++) {
            hs3.add(str[i]);
        }
        System.out.println(hs3.toString());

        Set lotto = new HashSet();


        while(lotto.size() < 6) {
            int random = (int) (Math.random()*45 + 1);
            lotto.add(random);
        }

        System.out.println(lotto.toString());


    }
}
