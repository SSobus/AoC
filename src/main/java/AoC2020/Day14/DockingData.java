package AoC2020.Day14;

import Utils.LoadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DockingData {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 14 *********************");
        List<String> instructions = LoadFile.LoadStrings("src/main/java/AoC2020/Day14/mask.txt");

        Part1(instructions);//Part 1
        Part2(instructions);//Part 2
    }

    public static void Part1(List<String> instructions) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer = 0;

        Map<Long, String> memory = new HashMap<>();
        Long mask = 0L;
        Long maskNot = 0L;

        for (String instruction : instructions) {
            String value = instruction.substring(instruction.indexOf("=") + 1).trim();

            if (instruction.startsWith("mask")) {
                mask = Long.parseLong(value.replace("X", "0"), 2);
                maskNot = Long.parseLong(value.replace("X", "1"), 2);
                continue;
            }

            String mem = instruction.substring(instruction.indexOf("[") + 1, instruction.indexOf("]")).trim();

            Long test = Long.parseLong(value);
            String and = Long.toBinaryString(mask & test);
            String or = Long.toBinaryString(mask | test);

            System.out.println("mask: " + String.format("%35s", Long.toBinaryString(mask)).replace(" ", "0"));
            System.out.println("val : " + String.format("%35s", Long.toBinaryString(test)).replace(" ", "0"));
            System.out.println("and : " + String.format("%35s", and).replace(" ", "0"));
            System.out.println("or  : " + String.format("%35s", or).replace(" ", "0"));
        }

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<String> instructions) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        long answer = 0;


        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
