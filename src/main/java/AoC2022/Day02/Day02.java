package AoC2022.Day02;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class Day02 {


    public static void runDay() throws IOException {
        System.out.println("2022 - Day 2 *********************");
        List<String> strings = LoadFile.LoadStrings("src/main/java/AoC2022/Day02/data.txt");

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

        int score = 0;
        for (String play : strings) {
            switch (play) {
                case "A X" -> score += Play.ROCK.getNumVal() + Outcome.DRAW.getNumVal();
                case "A Y" -> score += Play.PAPER.getNumVal() + Outcome.WIN.getNumVal();
                case "A Z" -> score += Play.SCISSORS.getNumVal() + Outcome.LOSE.getNumVal();
                case "B X" -> score += Play.ROCK.getNumVal() + Outcome.LOSE.getNumVal();
                case "B Y" -> score += Play.PAPER.getNumVal() + Outcome.DRAW.getNumVal();
                case "B Z" -> score += Play.SCISSORS.getNumVal() + Outcome.WIN.getNumVal();
                case "C X" -> score += Play.ROCK.getNumVal() + Outcome.WIN.getNumVal();
                case "C Y" -> score += Play.PAPER.getNumVal() + Outcome.LOSE.getNumVal();
                case "C Z" -> score += Play.SCISSORS.getNumVal() + Outcome.DRAW.getNumVal();
            }
        }


        //END CODE

        System.out.format("Result: %d", score).println();

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
        int score = 0;
        for (String play : strings) {
            switch (play) {
                case "A X" -> score += Play.SCISSORS.getNumVal() + Outcome.LOSE.getNumVal();
                case "A Y" -> score += Play.ROCK.getNumVal() + Outcome.DRAW.getNumVal();
                case "A Z" -> score += Play.PAPER.getNumVal() + Outcome.WIN.getNumVal();
                case "B X" -> score += Play.ROCK.getNumVal() + Outcome.LOSE.getNumVal();
                case "B Y" -> score += Play.PAPER.getNumVal() + Outcome.DRAW.getNumVal();
                case "B Z" -> score += Play.SCISSORS.getNumVal() + Outcome.WIN.getNumVal();
                case "C X" -> score += Play.PAPER.getNumVal() + Outcome.LOSE.getNumVal();
                case "C Y" -> score += Play.SCISSORS.getNumVal() + Outcome.DRAW.getNumVal();
                case "C Z" -> score += Play.ROCK.getNumVal() + Outcome.WIN.getNumVal();
            }
        }

        //END CODE

        System.out.format("Result : %d", score).println();

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    enum Play {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        private final int numVal;

        Play(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }
    }


    enum Outcome {
        LOSE(0),
        DRAW(3),
        WIN(6);

        private final int numVal;

        Outcome(int numVal) {
            this.numVal = numVal;
        }

        public int getNumVal() {
            return numVal;
        }

    }


}
