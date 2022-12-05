package AoC2022.Day03;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 3 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day03/data.txt");

        Part1(strings);//Part 1
        Part2(strings);//Part 2
    }

    /**
     * @param strings List of integers to search through
     */
    private static void Part1(List<String> strings) {
        long start = System.nanoTime();
        System.out.println("Part 1:");

        //CODE HERE

        int sum = 0;
        for (String string : strings) {
            char duplicateCharacter = getDuplicateCharacter(string);
            int characterValue = duplicateCharacter > 90 ? (duplicateCharacter - 96) : (duplicateCharacter - 38);
            sum += characterValue;
        }

        //END CODE

        System.out.format("Result: %d", sum).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static char getDuplicateCharacter(String line) {
        List<Set<Character>> list = new ArrayList<>();
        list.add(line.substring(0, line.length() / 2).chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));
        list.add(line.substring(line.length() / 2).chars().mapToObj(c -> (char) c).collect(Collectors.toSet()));

        list.get(0).retainAll(list.get(1));

        return list.get(0).iterator().next();
    }

    /**
     * @param strings List of Integers to search through
     */
    private static void Part2(List<String> strings) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        //CODE HERE
        final List<List<String>> groups = new ArrayList<>();
        for (int i = 0; i < strings.size(); i += 3) {
            List<String> group = new ArrayList<>();
            group.add(strings.get(i));
            group.add(strings.get(i + 1));
            group.add(strings.get(i + 2));
            groups.add(group);
        }

        int sum = 0;
        for (List<String> group : groups) {
            char matchingCharacter = getMatchingCharacter(group);
            int characterValue = matchingCharacter < 91 ? (matchingCharacter - 38) : (matchingCharacter - 96);
            sum += characterValue;
        }
        //END CODE

        System.out.format("Result : %d", sum).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static char getMatchingCharacter(List<String> line) {

        final List<Set<Character>> list = new ArrayList<>();
        for (String s : line) {
            Set<Character> collect = s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
            list.add(collect);
        }

        list.get(0).retainAll(list.get(1));
        list.get(0).retainAll(list.get(2));

        return list.get(0).iterator().next();
    }
}
