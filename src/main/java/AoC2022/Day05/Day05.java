package AoC2022.Day05;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Day05 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 5 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day05/data.txt");

        List<Deque<Character>> stacks = getStartingBoxStacks(strings);
        List<Move> moves = getMoves(strings);

        Part1(strings);//Part 1
        Part2(strings);//Part 2
    }

    private static List<Deque<Character>> getStartingBoxStacks(List<String> strings) {
        int blankLine = strings.indexOf("");
        int amountOfStacks = (int) Arrays.stream(strings.get(blankLine - 1).split("\\s+")).count() - 1;

        List<Deque<Character>> stacks = IntStream.range(0, amountOfStacks).<Deque<Character>>mapToObj(element -> new ArrayDeque<>()).collect(Collectors.toList());

        for (int i = amountOfStacks; i > 0; i--) {
            String line = strings.get(i);
            //get boxes and stack them
            for (int position = 1; position < line.length(); position += 4) {
                char character = line.charAt(position);
                if (Character.isAlphabetic(character)) {
                    stacks.get((position / 4)).push(character);
                }
            }

        }
        return null;
    }

    private static List<Move> getMoves(List<String> strings) {
        return null;
    }

    /**
     * @param strings List of integers to search through
     */
    private static void Part1(List<String> strings) {
        long start = System.nanoTime();
        System.out.println("Part 1:");

        //CODE HERE


        //END CODE

        System.out.format("Result: %d", 0).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    /**
     * @param strings List of Integers to search through
     */
    private static void Part2(List<String> strings) {
        long start = System.nanoTime();
        System.out.println("Part 2:");

        //CODE HERE


        //END CODE

        System.out.format("Result : %d", 0).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }


    private class Move {
        int FromPositions;
        int NumberOfBoxes;
        int ToPosition;

        public int getFromPositions() {
            return FromPositions;
        }

        public void setFromPositions(int fromPositions) {
            FromPositions = fromPositions;
        }

        public int getNumberOfBoxes() {
            return NumberOfBoxes;
        }

        public void setNumberOfBoxes(int numberOfBoxes) {
            NumberOfBoxes = numberOfBoxes;
        }

        public int getToPosition() {
            return ToPosition;
        }

        public void setToPosition(int toPosition) {
            ToPosition = toPosition;
        }
    }
}
