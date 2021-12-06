package AoC2021.Day01;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class SonarSweep {


    public static void runDay() throws IOException {
        System.out.println("2020 - Day 1 *********************");
        List<Integer> integers = LoadFile.LoadIntegers("src/main/java/AoC2021/Day01/data.txt");

        Part1(integers);//Part 1
        Part2(integers);//Part 2
    }

    /**
     * Find the number of times the depth increases
     * @param integers List of integers to search through
     */
    private static void Part1(List<Integer> integers) {
        long start = System.nanoTime();
        System.out.println("Part 1:");

        int count = 0;

        for (int i = 0; i < integers.size() - 1; i++) {
            if(integers.get(i) < integers.get(i + 1)){
                count++;
            }
        }

        System.out.format("Total Drops: %d", count).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }



    /**
     * Find the number of times the depth increases
     * @param integers List of Integers to search through
     */
    private static void Part2(List<Integer> integers) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        int count = 0;

        for (int i = 0; i < integers.size()-3; i++) {
            if(integers.get(i) + integers.get(i + 1) + integers.get(i + 2) < integers.get(i + 1) + integers.get(i + 2) + integers.get(i + 3)){
                count++;
            }
        }

        System.out.format("Total Drops: %d", count).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }


}
