package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<String> list;
    public static void main(String[] args) {

        list = new ArrayList<>();
        list.add("Tom");
        list.add("Linda");
        list.add("Ruby");
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> it;
        System.out.println(list + " " + list.size());

//        remove 에러: ConcurrentModificationException
//        for(String name: list){
//            if(name.equals("Tom")){
//                list.remove(name);
//            }
//        }
//        System.out.println(list);

//        remove: 성공
        it = list.listIterator();
        while (it.hasNext()) {
            String person = it.next();

            if (person.equals("Tom")) {
                it.remove();
            }
        }
        System.out.println(list + " " + list.size());
//        add 에러: ConcurrentModificationException
//        for(String name: list){
//            if(name.equals("Tom")){
//                list.add(name);
//            }
//        }
//        System.out.println(list);

//        add: 성공
        while (it.hasNext()) {
            String person = it.next();
            if (person.equals("Tom")) {
                it.add("ADDED");
            }
        }
        System.out.println(list + " " + list.size());


        List<Integer> l = Arrays.asList(2, 3, 6, 1, 9);
        // 변경 X
        l.forEach(p -> p *= 2);
        System.out.println(l);
        // 변경 O
        l = l.stream().map(p -> p * 2).collect(Collectors.toList());
        System.out.println(l);

        List<String> s = Arrays.asList("Kim", "Jack", "Lee", "Dacuya");
        // 변경 X
        s.forEach(p -> p = "A");
        System.out.println(s);
        // 변경 O
        s = s.stream().map(p -> p = "A").collect(Collectors.toList());
        System.out.println(s);

    }
}
