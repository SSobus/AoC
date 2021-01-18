package AoC2020.Day13;

import Utils.LoadFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShuttleSearch {

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 12 *********************");
        List<String> busStrings = LoadFile.LoadStrings("src/main/java/AoC2020/Day13/buses.txt");

        Integer timestamp = Integer.parseInt(busStrings.get(0));
        List<Integer> buses = Arrays.stream(busStrings.get(1).split(",")).filter(bus -> !bus.equals("x")).map(Integer::valueOf).collect(Collectors.toList());

        Part1(timestamp, buses);//Part 1
        Part2(timestamp, buses);//Part 2
    }

    public static void Part1(Integer timestamp, List<Integer> buses) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;
        int lowest = Integer.MAX_VALUE;
        int busNo = 0;

        for (Integer bus : buses) {
            int factor = timestamp / bus;
            int difference = ((factor + 1) * bus) - timestamp;

            if (difference < lowest) {
                lowest = difference;
                busNo = bus;
            }

        }

        answer = busNo * lowest;

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(Integer timestamp, List<Integer> buses) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int answer = 0;

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
