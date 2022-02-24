package AoC2020.Day15;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RambunctiousRecitation {


    //Numbers: 2,0,6,12,1,3

    static List<Integer> numbers = Arrays.asList(2, 0, 6, 12, 1, 3);

    static HashMap<Integer, Integer> numbersCalled = new HashMap<>();

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 15 *********************");

        Part1();//Part 1
        Part2();//Part 2
    }

    public static void Part1() {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;

        Integer round = 0;
        Integer call = 0;
        int lastCall = 0;

        for (Integer num : numbers) {

            numbersCalled.put(num, round);
            lastCall = num;
            round++;
        }

//        for (int nextIndex = spoken.size(); nextIndex < number - 1; nextIndex++) {
//            int recent = spoken.containsKey(last) ? nextIndex - spoken.get(last) : 0;
//            spoken.put(last, nextIndex);
//            last = recent;
//        }
        do {

            if (numbersCalled.containsKey(lastCall)) {
                call = round - numbersCalled.get(lastCall);
            } else {
                call = 0;
            }

            numbersCalled.put(lastCall, round);
            lastCall = call;
            round++;

        } while (round < 2020);

        System.out.println("Answer: " + call);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2() {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        long answer = 0L;

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
