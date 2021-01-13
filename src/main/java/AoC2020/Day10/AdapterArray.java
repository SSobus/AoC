package AoC2020.Day10;

import Utils.LoadFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AdapterArray {
    static Map<Integer, Long> paths = new HashMap<>();

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 10 *********************");
        List<Integer> adapters = LoadFile.LoadIntegers("src/main/java/AoC2020/Day10/adapters.txt");

        adapters.add(0);
        adapters.sort(Integer::compareTo);
        adapters.add(adapters.get(adapters.size() - 1) + 3);

        Part1(adapters);//Part 1
        Part2(adapters);//Part 2
    }

    public static void Part1(List<Integer> adapters) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;

        ConcurrentMap<Integer, AtomicInteger> answersMap = new ConcurrentHashMap<>();

        answersMap.putIfAbsent(1, new AtomicInteger(0));
        answersMap.putIfAbsent(2, new AtomicInteger(0));
        answersMap.putIfAbsent(3, new AtomicInteger(0));

        for (int i = 1; i < adapters.size(); i++) {
            answersMap.get(adapters.get(i) - adapters.get(i - 1)).incrementAndGet();
        }

        answer = answersMap.get(1).get() * answersMap.get(3).get();

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<Integer> adapters) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        Long answer;

        answer = followBranch(adapters, 0);

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    private static Long followBranch(List<Integer> adapters, int position) {
        if (position == (adapters.size() - 1)) return 1L;

        if (paths.containsKey(position)) return paths.get(position);
        Long answer = 0L;
        for (int current = position + 1; current < adapters.size(); current++) {
            if (adapters.get(current) - adapters.get(position) > 3) {
                break;
            }
            answer += followBranch(adapters, current);
        }
        paths.put(position, answer);
        return answer;
    }

}
