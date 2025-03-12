package org.example.collections.queue;

import java.util.*;


public class ListExample {
//    add(index, value), addAll(index,collection), replaceAll(UniaryOperator), sort(comparator), get(), set(index,ele), remove, indexof(Object),lastIndexOf
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(55);
        list.add(45);
        list.add(0,33);
        System.out.println(list);

        List<Integer> list1= Arrays.asList(1,2,3);

        list.addAll(0,list1);
        System.out.println(list);

        list.replaceAll((value)->value+1);
        System.out.println(list);

        list.sort(Comparator.comparingInt(a -> a));
        System.out.println(list);

        System.out.println(list.get(0));

        list.set(0,100);
        list.add(100);
        System.out.println(list.get(0));
        System.out.println(list);
        System.out.println(list.indexOf(100));
        System.out.println(list.lastIndexOf(100));


        System.out.println("list iterator");
        ListIterator<Integer> integerListIterator = list.listIterator();

        while (integerListIterator.hasNext()){
            System.out.print(integerListIterator.next()+"   ");
        }
        System.out.println();

        System.out.println(list.subList(3,7));

    }
}
