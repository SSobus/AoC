package AoC2022.Day06;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;


public class Day06 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 6 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day06/data.txt");

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
        int position = findPositionWithDistinctCount(strings.get(0), 4);
        //END CODE

        System.out.format("Result: %d", position).println();

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
        int position = findPositionWithDistinctCount(strings.get(0), 14);
        //END CODE

        System.out.format("Result : %d", position).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static int findPositionWithDistinctCount(String str, int distinctCount) {
        int position = 0;

        char[] characters = new char[distinctCount];
        char[] line = str.toCharArray();
        for (int i = 0; i < line.length; i++) {
            characters[i % distinctCount] = line[i];

            if ((int) String.copyValueOf(characters).chars().distinct().count() == distinctCount && i > distinctCount - 1) {
                position = i + 1;
                break;
            }
        }
        return position;
    }
}
