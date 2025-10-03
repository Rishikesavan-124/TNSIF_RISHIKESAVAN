package com.tnsif.streamapi;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)       // keep even numbers
                .map(n -> n * n)               // square them
                .collect(Collectors.toList()); // collect into list

        System.out.println("Even Squares: " + evenSquares);
    }
}
