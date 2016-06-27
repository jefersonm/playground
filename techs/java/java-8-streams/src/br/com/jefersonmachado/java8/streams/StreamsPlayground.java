package br.com.jefersonmachado.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsPlayground {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        mapExample(numbers);
        filterExample(numbers);
        reduceExample(numbers);
    }

    private static void mapExample(List<Integer> numbers) {
        List<Integer> squaresList = numbers
                .stream()
                .map(i -> i*i)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Map example: " + squaresList);
    }

    private static void filterExample(List<Integer> numbers){
        List<Integer> oddNumbers = numbers
                .stream()
                .filter(i -> i%2 != 0)
                .collect(Collectors.toList());

        System.out.println("Filter example: " + oddNumbers);
    }

    private static void reduceExample(List<Integer> numbers){
        Integer sum = numbers
                .stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Reduce example: " + sum);

    }




}
