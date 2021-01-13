package AoC2020.Day09;

import Utils.LoadFile;
import org.apache.commons.collections4.queue.CircularFifoQueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EncodingError {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 9 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2020/Day09/numbers.txt");

        ArrayList<Long> numbers = new ArrayList<>();

        for (String number : strings) {
            numbers.add(Long.parseLong(number));
        }

        Part1(numbers);//Part 1
    }

    public static void Part1(ArrayList<Long> numbers) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        Long answer = 0L;
        int preamble = 25;

        CircularFifoQueue<Long> queue = new CircularFifoQueue<>(preamble);

        for (int i = 0; i < preamble; i++) {
            queue.add(numbers.get(i));
        }

        for (int i = preamble; i < numbers.size(); i++) {
            //get possible numbers
            List<Long> possibleNumbers = new ArrayList<>();
            for (int begin = 0; begin < preamble; begin++) {
                for (int end = begin + 1; end < preamble; end++) {
                    possibleNumbers.add(queue.get(begin) + queue.get(end));
                }
            }

            if (!possibleNumbers.contains(numbers.get(i))) {
                answer = numbers.get(i);
                break;
            }

            queue.add(numbers.get(i));
        }

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");

        Part2(numbers, answer);
    }

    public static void Part2(ArrayList<Long> numbers, Long find) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        long answer = 0L;

        List<Long> contiguousNumbers;
        Long addition;
        boolean found = false;

        for (int begin = 0; !found; begin++) {
            contiguousNumbers = new ArrayList<>();
            addition = 0L;
            for (int current = begin; current < numbers.size() || found; current++) {
                contiguousNumbers.add(numbers.get(current));
                addition += numbers.get(current);

                if (find.equals(addition)) {
                    answer = contiguousNumbers.stream().max(Long::compareTo).orElse(0L) + contiguousNumbers.stream().min(Long::compareTo).orElse(0L);
                    found = true;
                } else if (addition > find) {
                    break;
                }
            }
        }

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
