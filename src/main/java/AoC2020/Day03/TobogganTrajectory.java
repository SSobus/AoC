package AoC2020.Day03;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class TobogganTrajectory {

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 3 *********************");
        List<String> trees = LoadFile.LoadStrings("src/main/java/AoC2020/Day03/trees.txt");

        Part1(trees);//Part 1
        Part2(trees);//Part 2
    }

    public static void Part1(List<String> trees) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int treeCount = runSlope(trees, 3, 1);

        System.out.println("Tree Count: " + treeCount);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<String> trees) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int treeCount1 = runSlope(trees, 1, 1);
        int treeCount2 = runSlope(trees, 3, 1);
        int treeCount3 = runSlope(trees, 5, 1);
        int treeCount4 = runSlope(trees, 7, 1);
        int treeCount5 = runSlope(trees, 1, 2);

        System.out.format("Tree Counts: %d, %d, %d, %d, %d", treeCount1, treeCount2, treeCount3, treeCount4, treeCount5).println();
        System.out.format("Tree Product: %d", treeCount1 * treeCount2 * treeCount3 * treeCount4 * treeCount5).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    private static int runSlope(List<String> trees, int right, int down) {
        int treeCount = 0;
        int column = 0;
        for (int index = 0; index < trees.size(); index += down) {
            String treeLine = trees.get(index);
            if (treeLine.charAt(column) == '#') {
                treeCount++;
            }

            if (column + right >= treeLine.length()) {
                column += right - treeLine.length();
            } else {
                column += right;
            }
        }
        return treeCount;
    }
}
