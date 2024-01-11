package fools;


import java.util.*;

public class SortMap {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();
        scores.put("1", 1);
        scores.put("55", 55);
        scores.put("3", 3);
        scores.put("23", 23);

        SortedSet<Integer> keySet = new TreeSet<>(scores.values());

        for (Integer string : keySet) {
            System.out.println(string );
        }

        System.out.println("Взимаме max стойностите:");

        System.out.println(keySet.last());

        keySet.remove(keySet.last());
        System.out.println(keySet.last());
    }
}
