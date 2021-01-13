package AoC2020.Day05;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinaryBoarding {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 5 *********************");
        List<String> passes = LoadFile.LoadStrings("src/main/java/AoC2020/Day05/boarding.txt");


        Part1(passes);//Part 1
        Part2(passes);//Part 2
    }

    public static void Part1(List<String> passes) {
        System.out.println("Part 1:");
        long start = System.nanoTime();
        int highest = 0;

        for (String pass : passes) {
            String rowString = pass.substring(0, 7);
            String seatString = pass.substring(7);

            rowString = rowString.replaceAll("F", "0");
            rowString = rowString.replaceAll("B", "1");

            seatString = seatString.replaceAll("L", "0");
            seatString = seatString.replaceAll("R", "1");

            int row = Integer.parseInt(rowString, 2);
            int seat = Integer.parseInt(seatString, 2);

            int seatId = (row * 8) + seat;

            if (seatId > highest) {
                highest = seatId;
            }
        }

        System.out.println("Seat Id : " + highest);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<String> passes) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        List<Integer> seats = new ArrayList<>();

        int seatId = 0;

        for (String pass : passes) {
            String rowString = pass.substring(0, 7);
            String seatString = pass.substring(7);

            rowString = rowString.replaceAll("F", "0");
            rowString = rowString.replaceAll("B", "1");

            seatString = seatString.replaceAll("L", "0");
            seatString = seatString.replaceAll("R", "1");

            int row = Integer.parseInt(rowString, 2);
            int seat = Integer.parseInt(seatString, 2);

            seats.add((row * 8) + seat);
        }

        seats.sort(Integer::compareTo);
        for (int i = 0; i < (127*8)+7; i++) {
            //ignore first and last rows
            if (i > (1 * 8 + 7) && i < ((127 * 8 + 7) - 15)) {
                if(seats.contains(i+1) && seats.contains(i-1) && !seats.contains(i)){
                    seatId = i;
                }
            }
        }

        System.out.println("Your Seat: " + seatId);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
