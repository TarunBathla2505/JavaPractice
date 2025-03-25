package org.example.collections.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(54);
        list.add(23);
        list.add(10);
        list.add(155);
        list.add(21);
        list.add(21);
        list.add(54);


        // .stream is used to create a stream
        // .filter intermediate work
        // .collect terminal operation
        List<Integer> collect = list.stream().filter((x) -> x != 10).collect(Collectors.toList());
        System.out.println(collect);


        // lets have count of values greater than 23 which should give ans as 2
        long count = list.stream().filter((x) -> x > 23).count();
        System.out.println(count);

        // we can use any number of intermediate operations

        List<Integer> collect1 = list.stream().filter((x) -> x >= 23).map((value) -> value + 20).collect(Collectors.toList());
        System.out.println(collect1);

        System.out.println(list.stream().distinct().collect(Collectors.toList()));

        int[] arr  = {1,42,4,3,35,43,4,3,2,24,4};

        System.out.println(Arrays.toString(Arrays.stream(arr).sorted().toArray()));

        Arrays.stream(arr).forEach((e) -> System.out.print(e+"  "));
        System.out.println();

        System.out.println(Arrays.stream(arr).reduce((val1,val2) -> val1+val2).getAsInt());

        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(Arrays.stream(arr).max().getAsInt());


    }
}
