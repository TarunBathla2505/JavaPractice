package org.example.collections.basics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[4];
        arr[1]=6;
        Vector<Integer> vector = new Vector<>();

        vector.add(5);
        System.out.println(vector.get(0));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(5);

        System.out.println("using iterator");

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("using forEach method");
        list.forEach((Integer value)-> System.out.println(value));

        System.out.println("all collection methods");
        usingAllMethodsOfCollection();

    }
    public static void usingAllMethodsOfCollection(){
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.contains(1));

        list.remove((Integer) 2);
        System.out.println(list.contains(2));

        Stack<Integer> st = new Stack<>();
        st.add(1);
        st.add(2);
        st.add(3);

        list.addAll(st);
        System.out.println(list);
        System.out.println(list.containsAll(st));
        list.remove(Integer.valueOf(2));
        System.out.println(list.containsAll(st));
        list.clear();
        System.out.println(list.size());
    }
}
