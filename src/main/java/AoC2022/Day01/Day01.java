package AoC2022.Day01;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Day01 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 1 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day01/data.txt");

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

        int current = 0;
        int max = 0;
        for (String cal : strings) {
            if (Objects.equals(cal, "")) {
                if (current > max) {
                    max = current;
                }
                current = 0;
            } else {
                current += Integer.parseInt(cal);
            }
        }

        //END CODE

        System.out.format("Result: %d", max).println();

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
        int current = 0;
        List<Integer> currents = new ArrayList<>();
        int max = 0;
        for (String cal : strings) {
            if (Objects.equals(cal, "")) {
                if (current > max) {
                    max = current;
                }
                currents.add(current);
                current = 0;
            } else {
                current += Integer.parseInt(cal);
            }
        }
        currents.sort(Collections.reverseOrder());

        //END CODE

        System.out.format("Result : %d", currents.get(0) + currents.get(1) + currents.get(2)).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }


}
