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

        long answer = 0L;

        Map<Long, Long> memory = new HashMap<>();
        String mask = "";

        for (String instruction : instructions) {
            String rawString = instruction.substring(instruction.indexOf("=") + 1).trim();

            if (instruction.startsWith("mask")) {
                mask = rawString;
                continue;
            }

            long mask1 = Long.parseUnsignedLong(mask.replaceAll("X", "0"), 2);
            long mask2 = Long.parseUnsignedLong(mask.replaceAll("0", "1").replaceAll("X", "0"), 2);

            long value = Long.parseUnsignedLong(rawString);
            long ans = (value | (mask1 & mask2)) & (mask1 | ~mask2);

            String mem = instruction.substring(instruction.indexOf("[") + 1, instruction.indexOf("]")).trim();
            memory.put(Long.parseUnsignedLong(mem), ans);
        }

        for (long val : memory.values()) {
            answer += val;
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
