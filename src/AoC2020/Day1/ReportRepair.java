package AoC2020.Day1;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class ReportRepair {


    public static void runDay() throws IOException {
        System.out.println("2020 - Day 1 *********************");
        List<Integer> integers = LoadFile.LoadIntegers("src/AoC2020/Day1/numbers.txt");

        integers.sort(Integer::compareTo);

        Part1(integers);//Part 1
        Part2(integers);//Part 2
    }

    /**
     * Find the Product of two numbers whose sum is 2020
     * @param integers List of integers to search through
     */
    private static void Part1(List<Integer> integers) {
        long start = System.nanoTime();
        System.out.println("Part 1:");

        boolean finished = false;
        for (int i = 0; i < integers.size() && !finished; i++) {

            int secondIndex = integers.size() - 1;

            boolean searching = true;
            while (searching) {
                Integer first = integers.get(i);
                Integer second = integers.get(secondIndex);

                if (first + second == 2020) {
                    System.out.format("Numbers: %d, %d",first, second).println();
                    System.out.format("Total Product: %d", first * second).println();
                    finished = true;
                    break;
                } else if (first + second > 2020) {
                    secondIndex--;
                } else {
                    searching = false;
                }
            }
        }

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println(delta);
    }

    /**
     * Find the Product of three numbers whose sum is 2020
     * @param integers List of Integers to search through
     */
    private static void Part2(List<Integer> integers) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        boolean finished = false;
        for (int i = 0; i < integers.size() && !finished; i++) {
            int secondIndex = i + 1;
            int thirdIndex = i + 2;

            boolean searching = true;
            while (searching) {
                Integer first = integers.get(i);
                Integer second = integers.get(secondIndex);
                Integer third = integers.get(thirdIndex);

                if (first + second + third == 2020) {
                    System.out.format("Numbers: %d, %d, %d",first, second, third).println();
                    System.out.format("Total Product: %d", first * second * third).println();
                    finished = true;
                    break;
                } else if(first + second + third > 2020) {
                    break;
                } else if (thirdIndex == integers.size() - 1) {
                    secondIndex++;
                } else if(secondIndex == integers.size() - 2){
                    searching = false;
                } else {
                    thirdIndex++;
                }
            }
        }

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println(delta);
    }


}
