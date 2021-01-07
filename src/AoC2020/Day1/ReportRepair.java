package AoC2020.Day1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReportRepair {


    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("src/AoC2020/Day1/numbers.txt");
        Scanner scanner = new Scanner(filePath);
        List<Integer> integers = new ArrayList<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }
        integers.sort(Integer::compareTo);

        //2 numbers
        FindTwo(integers);

        //three numbers
        FindThree(integers);
    }

    private static void FindThree(List<Integer> integers) {
        Instant before = Instant.now();

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

        Instant after = Instant.now();
        long delta = Duration.between(before, after).toMillis();
        System.out.println(delta);
    }

    private static void FindTwo(List<Integer> integers) {
        Instant before = Instant.now();

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

        Instant after = Instant.now();
        long delta = Duration.between(before, after).toMillis();
        System.out.println(delta);
    }
}
