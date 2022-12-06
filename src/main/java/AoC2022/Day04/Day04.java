package AoC2022.Day04;

import Utils.LoadFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int overlapping = 0;
        for (String line : strings) {
            String[] assignments = line.split(",");
            int[] firstPair = Arrays.stream(assignments[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondPair = Arrays.stream(assignments[1].split("-")).mapToInt(Integer::parseInt).toArray();

            if (firstPair[0] >= secondPair[0] && firstPair[1] <= secondPair[1]) {
                overlapping++;
            } else if (secondPair[0] >= firstPair[0] && secondPair[1] <= firstPair[1]) {
                overlapping++;
            }
        }
        //END CODE

        System.out.format("Result: %d", overlapping).println();

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
        int overlapping = 0;
        for (String line : strings) {
            String[] assignments = line.split(",");
            int[] firstPair = Arrays.stream(assignments[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] secondPair = Arrays.stream(assignments[1].split("-")).mapToInt(Integer::parseInt).toArray();

            Set<Integer> firstAssignments = Arrays.stream(IntStream.rangeClosed(firstPair[0], firstPair[1]).toArray()).boxed().collect(Collectors.toSet());
            Set<Integer> secondAssignments = Arrays.stream(IntStream.rangeClosed(secondPair[0], secondPair[1]).toArray()).boxed().collect(Collectors.toSet());

            firstAssignments.retainAll(secondAssignments);

            if (firstAssignments.size() > 0) {
                overlapping++;
            }
        }
        //END CODE

        System.out.format("Result : %d", overlapping).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
