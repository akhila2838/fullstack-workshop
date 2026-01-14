package inventrory;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaRefactor {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList("Java", "Python", "C", "JavaScript"));
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        names.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        names.sort(Comparator.comparingInt(String::length));

        List<Integer> evens = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evens.add(n);
            }
        }


        Predicate<Integer> isEven = n -> n % 2 == 0;

        List<Integer> evensStream = numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());

        for (String s : names) {
            System.out.println(s);
        }


        names.forEach(s -> System.out.println(s));

        names.forEach(System.out::println);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> System.out.println("Running"));
        t2.start();


        List<String> upper = new ArrayList<>();
        for (String s : names) {
            upper.add(s.toUpperCase());
        }


        Function<String, String> toUpper = s -> s.toUpperCase();

        List<String> upperLambda = names.stream()
                .map(toUpper)
                .collect(Collectors.toList());

        List<String> upperMethodRef = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
