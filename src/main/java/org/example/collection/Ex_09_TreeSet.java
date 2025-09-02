package org.example.collection;

import java.util.Set;
import java.util.TreeSet;

public class Ex_09_TreeSet {
    public static void main (String[] args) {

        // set : 순서 X, 중복 X
        // TreeSet : 순서 X, 중복 X, 정렬 O

        Set<Integer> lotto = new TreeSet<>();

        while (lotto.size() < 6) {
            int randomMun = (int) (Math.random() * 45 + 1);
            lotto.add(randomMun);
        }
        System.out.println(lotto.toString());
    }
}
