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

        System.out.println(list + " " + list.size());

//        remove 에러: ConcurrentModificationException
//        for(String name: list){
//            if(name.equals("Tom")){
//                list.remove(name);
//            }
//        }
//        System.out.println(list);

//        remove: 성공
        ListIterator<String> it = list.listIterator();
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

        list.forEach(p -> p = "A");
        System.out.println("변경 X: " + list);
        list = list.stream()
                .map(p -> p.equals("A") ? "CHANGED" : p)
                .collect(Collectors.toList());
        System.out.println("변경 O: " + list);

    }
}
