package AoC2022.Day02;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class Day02 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 1 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day02/data.txt");

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

        int score = 0;
        for (String play : strings) {
            switch (play) {
                case "A X" -> score += 1 + 3;
                case "A Y" -> score += 2 + 6;
                case "A Z" -> score += 3;
                case "B X" -> score += 1;
                case "B Y" -> score += 2 + 3;
                case "B Z" -> score += 3 + 6;
                case "C X" -> score += 1 + 6;
                case "C Y" -> score += 2;
                case "C Z" -> score += 3 + 3;
            }
        }


        //END CODE

        System.out.format("Result: %d", score).println();

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
        int score = 0;
        for (String play : strings) {
            switch (play) {
                case "A X" -> score += 3;
                case "A Y" -> score += 1 + 3;
                case "A Z" -> score += 2 + 6;
                case "B X" -> score += 1;
                case "B Y" -> score += 2 + 3;
                case "B Z" -> score += 3 + 6;
                case "C X" -> score += 2;
                case "C Y" -> score += 3 + 3;
                case "C Z" -> score += 1 + 6;
            }
        }

        //END CODE

        System.out.format("Result : %d", score).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }


}
