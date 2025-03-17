package org.example.collections.maps;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(null,"Test");
        map.put(0,null);
        map.put(1,"1");
        map.put(2,"2");

        map.putIfAbsent(1,"10");

        for(Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+"     "+entry.getValue());
        }
        System.out.println(map.isEmpty());
        Map<Integer,String> map2 = new HashMap<>();
        map2.putAll(map);
        map.clear();
        System.out.println(map.isEmpty());

        System.out.println(map2.size());
        System.out.println(map2.containsKey(1));
        System.out.println(map2.get(1));
        map2.remove(null);
        for(Integer key : map2.keySet()){
            System.out.println(key);
        }
        Collection<String> values = map2.values();
        System.out.println(values);

        linkedHashMapWorking();
    }

    public static void linkedHashMapWorking(){
        System.out.println("linkedhashmap");
        Map<Integer,Integer> map = new LinkedHashMap<>();

        map.put(1,2);
        map.put(2,3);
        map.put(4,5);

        map.forEach((key,val) -> System.out.println(key));
        treeHashMapWorking();
    }
    public static void treeHashMapWorking(){
        System.out.println("treemap");
        SortedMap<Integer,Integer> map = new TreeMap<>();

        map.put(1,2);
        map.put(2,3);
        map.put(0,5);

        System.out.println(map.headMap(1));
        System.out.println(map.tailMap(1));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        map.forEach((key,val) -> System.out.println(key));
    }
}
