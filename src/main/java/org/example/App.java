package org.example;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

         IntSummaryStatistics summary  = listOfIntegers.stream().collect(summarizingInt(i -> (Integer) i));
        int max = summary.getMax();

        IntStream.range(1, 10).map(i -> i+2).forEach(System.out::println);

        Function<Integer, Double> fn = (a) -> {
            double v = a / 2.0;
                    return v;
        };
    }
}
