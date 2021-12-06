package AoC2021.Day02;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class Dive {


    public static void runDay() throws IOException {
        System.out.println("2021 - Day 2 *********************");
        List<String> integers = LoadFile.LoadStrings("src/main/java/AoC2021/Day02/data.txt");

        Part1(integers);//Part 1
        Part2(integers);//Part 2
    }

    /**
     * Find the number of times the depth increases
     * @param lines List of integers to search through
     */
    private static void Part1(List<String> lines){
        long start = System.nanoTime();
        System.out.println("Part 1:");

        int depth = 0;
        int horizontal = 0;

        String[] words;
        int amount;

        for (String line: lines ) {

            words = line.split(" ");
            amount = Integer.parseInt(words[1]);

            switch (words[0]) {
                case "up" -> depth -= amount;
                case "down" -> depth += amount;
                case "forward" -> horizontal += amount;
            }
        }

        System.out.format("Answer: %d", depth * horizontal).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }



    /**
     * Find the number of times the depth increases
     * @param lines List of Integers to search through
     */
    private static void Part2(List<String> lines) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        int aim = 0;
        int depth = 0;
        int horizontal = 0;

        String[] words;
        int amount;

        for (String line: lines ) {

            words = line.split(" ");
            amount = Integer.parseInt(words[1]);

            switch (words[0]) {
                case "up" -> aim -= amount;
                case "down" -> aim += amount;
                case "forward" -> {
                    horizontal += amount;
                    depth += (aim * amount);
                }
            }
        }

        System.out.format("Answer: %d", depth * horizontal).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }


}
