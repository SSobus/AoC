package AoC2020.Day07;

import Utils.LoadFile;

import java.io.IOException;
import java.util.*;

public class HandyHaversacks {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 7 *********************");
        List<String> bags = LoadFile.LoadStrings("src/main/java/AoC2020/Day07/bags.txt");

        Map<String, List<Contents>> bagContents = buildContents(bags);

        Part1(bagContents);//Part 1
        Part2(bagContents);//Part 2
    }

    public static void Part1(Map<String, List<Contents>> bagContents) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int count = 0;

        String findBag = "shiny gold";

        Set<String> bags = bagContents.keySet();
        for (String name : bags) {
            if (bagRecursion(bagContents, name, findBag)) {
                count++;
            }
        }

        System.out.println("Count: " + count);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(Map<String, List<Contents>> bagContents) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int count = 0;

        String findBag = "shiny gold";

        count += (bagRecursion(bagContents, findBag));


        System.out.println("Count: " + count);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    private static Map<String, List<Contents>> buildContents(List<String> rules) {
        Map<String, List<Contents>> bagContents = new HashMap<>();

        rules.forEach(rule -> {
            String name = rule.substring(0, rule.indexOf("contain")).replace(" bags", "").replace(" bag", "").replace(".", "").trim();

            List<Contents> contents = new ArrayList<>();

            Arrays.stream(rule.substring(rule.indexOf("contain") + 8).split(",")).forEach(child -> {
                child = child.trim();

                if (child.indexOf("no ") != 0) {
                    int number = Integer.parseInt(child.substring(0, child.indexOf(" ")));
                    String childName = child.substring(child.indexOf(" ")).replace(" bags", "").replace(" bag", "").replace(".", "").trim();

                    contents.add(new Contents(childName, number));
                }
            });

            bagContents.put(name, contents);
        });

        return bagContents;
    }

    private static Boolean bagContains(List<Contents> contents, String bagName) {
        for (Contents bag : contents) {
            if (bag.getName().equals(bagName)) {
                return true;
            }
        }
        return false;
    }

    private static Boolean bagRecursion(Map<String, List<Contents>> mapContents, String nextBag, String findName) {
        List<Contents> contents = mapContents.get(nextBag);

        if (contents == null) {
            return false;
        }

        boolean found = false;
        for (Contents content : contents) {
            if (bagContains(contents, findName)) {
                return true;
            }
            if (bagRecursion(mapContents, content.getName(), findName)) {
                found = true;
            }
        }

        return found;
    }

    private static Integer bagRecursion(Map<String, List<Contents>> mapContents, String nextBag) {
        List<Contents> contents = mapContents.get(nextBag);

        if (contents == null) {
            return 0;
        }

        int amount = 0;
        for (Contents content : contents) {
            amount += bagRecursion(mapContents, content.getName()) * content.getAmount() + content.getAmount();
        }

        return amount;
    }
}
