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
        while(it.hasNext()){
            String person = it.next();

            if(person.equals("Tom")){
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
        while(it.hasNext()){
            String person = it.next();
            if(person.equals("Tom")) {
                it.add("ADDED");
            }
        }
        System.out.println(list + " " + list.size());


//        String[] name = {"Kim", "Jack", "Lee", "Dacuya"};
//        int i = 0;
//        for(String Nm :name){
//            if(Nm.equals("Kim")){
//                Nm = "PARK";
//            }
//            System.out.println("name: " + Nm + " " + name[i]);
//            i++;
//        }
//        for(String Nm :name){
//            System.out.print(Nm + " ");
//        }
//        System.out.println("\nEND");
        
        List<Integer> l = Arrays.asList(2,3,6,1,9);
        l.forEach(p->p*=2);
        System.out.println(l);

        List<Integer> num = Arrays.asList(2,3,6,1,9);
        num=num.stream().map(p -> p * 2).collect(Collectors.toList());
        System.out.println(num);

//        it = list.listIterator();
//        while(it.hasNext()){
//            int idx = it.nextIndex();
//            String person = it.next();
//
//            System.out.println("Person: " + person + " " + idx);
//        }
//

//
//        System.out.println("\nremove\n");
//
//        it = list.listIterator();
//        while(it.hasNext()){
//            int idx = it.nextIndex();
//            String person = it.next();
//            System.out.println("Person: " + person + " " + idx);
//        }



//        System.out.println("\nset & previous\n");
//        it.set("Belly");
//
//        while(it.hasPrevious()){
//            String person = it.previous();
//
//            System.out.println("Person: " + person);
//        }
//
//
//        System.out.println("\nadd\n");
//        it.add("new");
//        it = list.listIterator();
//        while(it.hasNext()){
//            int idx = it.nextIndex();
//            String person = it.next();
//            System.out.println("Person: " + person + " " + idx);
//        }
//
//        System.out.println("\nprevious\n");
//        while(it.hasPrevious()){
//            int idx = it.previousIndex();
//            String person = it.previous();
//
//            System.out.println("Person: " + person + " " + idx);
//        }

    }
//    public void print(){
//        for(String name: list){
//            System.out.println()
//        }
//    }
}
