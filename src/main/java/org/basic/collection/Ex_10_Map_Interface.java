package org.basic.collection;

import java.util.Collection;
import java.util.HashMap;

public class Ex_10_Map_Interface {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Tiger","1004");
        map.put("scott","2300");
        map.put("superman","4422");

        System.out.println(map.containsKey("tiger")); //false
        System.out.println(map.containsValue("4422")); //true
        System.out.println(map.get("scott")); //2300
        System.out.println(map.size()); //3
        map.put("Tiger","1008");
        System.out.println(map.toString()); //{scott=2300, superman=4422, Tiger=1008}
        map.remove("superman"); //Object value를 던짐

        //내부적으로 Set을 구현하고 있는 주소값을 리턴함
        System.out.println(map.keySet()); // [scott, Tiger] or [Tiger, scott]

        Collection clist= map.values();
        System.out.println(clist.toString()); //[2300, 1008]

    }
}
