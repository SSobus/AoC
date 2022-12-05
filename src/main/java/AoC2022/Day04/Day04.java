package AoC2022.Day04;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class Day04 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 4 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day04/data.txt");

        Part1(strings);//Part 1
        Part2(strings);//Part 2
    }

    /**
     * @param strings List of integers to search through
     */
    private static void Part1(List<String> strings) {
        long start = System.nanoTime();
        System.out.println("Part 1:");

        //CODE HERE

        //END CODE

        System.out.format("Result: %d", 0).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    /**
     * @param strings List of Integers to search through
     */
    private static void Part2(List<String> strings) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        //CODE HERE

        //END CODE

        System.out.format("Result : %d", 0).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
