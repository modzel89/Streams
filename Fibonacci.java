package com.pawel.modzelewski.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    public static int LOCAL_MEMORY_1 = 0;

    public static int LOCAL_MEMORY_2 = 0;

    public static void main(String[] args) {
        long time1 = System.nanoTime();
        final Stream<Integer> iterate = Stream.iterate(0, (Integer i) -> {
            LOCAL_MEMORY_1 = i == 0 ? 1 : LOCAL_MEMORY_2;
            LOCAL_MEMORY_2 = i;
            return LOCAL_MEMORY_1 + LOCAL_MEMORY_2;
        });
        iterate.limit(1000000);
        long time2 = System.nanoTime();
        System.out.println(time2 - time1);
        // System.out.println(iterate.limit(1000000).collect(Collectors.toList()));
    }
}
