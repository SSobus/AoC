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

        Map<Long, String> memory = new HashMap<>();
        String mask = "";

        for (String instruction : instructions) {
            String rawString = instruction.substring(instruction.indexOf("=") + 1).trim();

            if (instruction.startsWith("mask")) {
                mask = rawString;
                continue;
            }

            long value = Long.parseUnsignedLong(rawString);
            String binaryStr = String.format("%36s", Long.toUnsignedString(value, 2)).replace(" ", "0");

            //TODO: use bit manipulation - research and see how to do it with & | ^ ~
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mask.length(); i++) {
                char maskChar = mask.charAt(i);
                if (maskChar == 'X') {
                    result.append(binaryStr.charAt(i));
                } else if (maskChar == '0' || maskChar == '1') {
                    result.append(maskChar);
                }
            }

//            System.out.println("raw : " + String.format("%d", value));
//            System.out.println("val : " + String.format("%36s", binaryStr.replace(" ", "0")));
//            System.out.println("mask: " + String.format("%36s", mask.replace(" ", "0")));
//            System.out.println("res : " + String.format("%36s", result.toString().replace(" ", "0")));
            String mem = instruction.substring(instruction.indexOf("[") + 1, instruction.indexOf("]")).trim();
            memory.put(Long.parseLong(mem), result.toString());
        }

        for (String val : memory.values()) {
            answer += Long.parseUnsignedLong(val, 2);
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
