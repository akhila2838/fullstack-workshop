package oop_advanced.generics;

import java.util.List;

public class GenericsTest {

    public static void main(String[] args) {

        // Pair test
        Pair<String, Integer> pair = new Pair<>("Age", 25);
        System.out.println(pair); // Pair{key='Age', value=25}

        // Box test
        Box<String> box = new Box<>();
        box.set("Hello");
        System.out.println(box.get()); // Hello
        System.out.println(box.isEmpty()); // false
        box.clear();
        System.out.println(box.isEmpty()); // true

        // CollectionUtils tests
        List<Integer> numbers = List.of(1, 5, 3, 9, 2);
        Integer max = CollectionUtils.findMax(numbers);
        System.out.println("Max: " + max); // 9

        List<String> names = List.of("Alice", "Bob", "Anna");
        List<String> aNames = CollectionUtils.filter(names, s -> s.startsWith("A"));
        System.out.println(aNames); // [Alice, Anna]

        String firstLongName =
                CollectionUtils.findFirst(names, name -> name.length() > 3);
        System.out.println(firstLongName); // Alice
    }
}
