package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one (15)");
        list.add("five (16)");
        list.add("two (22)");
        list.add("mine (33)");
        list.add("finger (11)");

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Pair pair = new Pair();
            pair.setText(list.get(i));
            String valueAsString = list.get(i).replaceAll("[^0-9]" , "");
            Integer valueAsInt = Integer.valueOf(valueAsString);
            pair.setValue(valueAsInt);
            pairs.add(pair);
        }

        List<Pair> sortedPairs = pairs.stream().sorted(Comparator.comparing(Pair::getValue)).collect(Collectors.toList());
        System.out.println();

        Comparator<String> comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = Integer.valueOf(o1.toString().replaceAll("[^0-9]" , ""));
                Integer i2 = Integer.valueOf(o2.toString().replaceAll("[^0-9]" , ""));
                return i1.compareTo(i2);
            }
        };
        List<String> sorted = list.stream().sorted(comparator).collect(Collectors.toList());
        System.out.println(sorted);
    }
}
