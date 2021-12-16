package AoC2021.Day03;

import Utils.LoadFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BinaryDiagnostic {


    public static void runDay() throws IOException {
        System.out.println("2021 - Day 3 *********************");
        List<String> integers = LoadFile.LoadStrings("src/main/java/AoC2021/Day03/data.txt");

        Part1(integers);//Part 1
        Part2(integers);//Part 2
    }

    /**
     * Find the number for diagnostics
     * @param lines List of binary strings to parse
     */
    private static void Part1(List<String> lines){
        long start = System.nanoTime();
        System.out.println("Part 1:");


        Integer[] countOfOnes = new Integer[12];
        Arrays.fill(countOfOnes, 0);

        for (String line: lines) {
            for (int index = 0; index < line.length(); index++) {
                countOfOnes[index] += Integer.parseInt(String.valueOf(line.charAt(index)));
            }
        }

        String gamma = Arrays.stream(countOfOnes).map(number -> number >= 500 ? "1" : "0").collect(Collectors.joining());
        String epsilon = Arrays.stream(countOfOnes).map(number -> number < 500 ? "1" : "0").collect(Collectors.joining());

        System.out.format("Answer: %d", Integer.parseUnsignedInt(gamma,2) * Integer.parseUnsignedInt(epsilon, 2)).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    /**
     * Find the number for diagnostics
     * @param lines List of binary strings to parse
     */
    private static void Part2(List<String> lines) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        int countOxygen = 0;
        int countCO = 0;
        int position = 0;

        List<String> oxygen = new ArrayList<>(lines);
        List<String> co = new ArrayList<>(lines);

        while (oxygen.size() > 1 || co.size() > 1) {
            int finalPosition = position;

            if(oxygen.size() > 1) {
                for (String line : oxygen) {
                    countOxygen += Integer.parseInt(String.valueOf(line.charAt(position)));
                }

                char significant = countOxygen >= oxygen.size() - countOxygen ? '1' : '0';
                oxygen = oxygen.stream().filter(line -> line.charAt(finalPosition) == significant).collect(Collectors.toList());
            }

            if(co.size() >1) {
                for (String line : co) {
                    countCO += Integer.parseInt(String.valueOf(line.charAt(position)));
                }

                char coSignificant = countCO >= co.size() -countCO ? '0' : '1';
                co = co.stream().filter(line -> line.charAt(finalPosition) == coSignificant).collect(Collectors.toList());
            }

            position++;
            countOxygen = 0;
            countCO = 0;
        }

        System.out.format("Answer: %d", Long.parseLong(oxygen.get(0), 2 ) * Long.parseLong(co.get(0), 2 ) ).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

}
