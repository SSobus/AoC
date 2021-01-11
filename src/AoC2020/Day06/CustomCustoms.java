package AoC2020.Day06;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CustomCustoms {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 6 *********************");
        List<String> answers = LoadFile.LoadStrings("src/AoC2020/Day06/answers.txt");

        Part1(answers);//Part 1
        Part2(answers);//Part 2
    }

    public static void Part1(List<String> answers) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        List<String> answersList = loadGroups(answers);
        int count = 0;

        for (String groupAnswers : answersList) {
            Map<String, Boolean> answersMap = new HashMap<>();
            Stream<String> stringStream = groupAnswers.codePoints().mapToObj(c -> String.valueOf((char) c));

            stringStream.forEach(answer -> {
                if (!answer.equals(",")) {
                    answersMap.put(answer, true);
                }
            });
            count += answersMap.size();
        }

        System.out.println("Count: " + count);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<String> answers) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        List<String> answersList = loadGroups(answers);
        int count = 0;

        for (String groupAnswers : answersList) {
            ConcurrentMap<String, AtomicInteger> answersMap = new ConcurrentHashMap<>();
            Stream<String> stringStream = groupAnswers.codePoints().mapToObj(c -> String.valueOf((char) c));

            AtomicInteger total = new AtomicInteger(0);

            stringStream.forEach(answer -> {
                if (!answer.equals(",")) {
                    answersMap.putIfAbsent(answer, new AtomicInteger(0));
                    answersMap.get(answer).incrementAndGet();
                } else {
                    total.getAndIncrement();
                }
            });

            count += answersMap.keySet().stream().filter(key -> answersMap.get(key).get() == total.get()).count();
        }

        System.out.println("Count: " + count);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    private static List<String> loadGroups(List<String> answersList) {
        List<String> groupAnswers = new ArrayList<>();

        StringBuilder answer = new StringBuilder();
        for (String line : answersList) {
            if (line.length() == 0) {
                groupAnswers.add(answer.toString());
                answer = new StringBuilder();
            } else {
                answer.append(line).append(",");
            }

        }
        groupAnswers.add(answer.toString());
        return groupAnswers;
    }
}
