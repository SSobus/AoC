package AoC2020.Day08;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HandheldHalting {

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 8 *********************");
        List<String> operations = LoadFile.LoadStrings("src/AoC2020/Day08/code.txt");

        List<Instruction> instructions = loadInstructions(operations);


        Part1(operations);//Part 1
        Part2(operations);//Part 2
    }

    private static List<Instruction> loadInstructions(List<String> tasks) {
        List<Instruction> instructions = new ArrayList<>();


        for (String operation : tasks) {
            String task = operation.substring(0, 3);
            Integer amount = Integer.parseInt(operation.substring(4));

            instructions.add(new Instruction(task, amount, false));
        }

        return instructions;
    }

    public static void Part1(List<String> operations) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        List<Instruction> instructions = loadInstructions(operations);

        int answer = 0;

        Integer position = 0;
        while (true) {
            Instruction instruction = instructions.get(position);

            if (instruction.executed) {
                break;
            }

            switch (instruction.operation) {
                case "acc" -> {
                    answer += instruction.amount;
                    position++;
                }
                case "jmp" -> position += instruction.amount;
                case "nop" -> position++;
            }

            instruction.executed = true;

            if (position >= instructions.size()) {
                break;
            }
        }

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    //incorrect line is 278
    public static void Part2(List<String> operations) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        List<Instruction> instructions = loadInstructions(operations);

        int answer = 0;
        Integer currentPosition = 0;
        boolean found = false;

        do {
            Instruction instruction = instructions.get(currentPosition);

            List<Instruction> usedTestInstructions = new ArrayList<>();

            Integer testPosition = currentPosition;

            String testOperation = instructions.get(testPosition).getOperation();
            Integer testAmount = instructions.get(testPosition).getAmount();

            //test from current path + jmp/nop switch
            switch (testOperation) {
                case "nop" -> testOperation = "jmp";
                case "jmp" -> testOperation = "nop";
            }

            while (!found) {
                if (usedTestInstructions.contains(instructions.get(testPosition))) {
                    break;
                } else {
                    usedTestInstructions.add(instructions.get(testPosition));
                }

                switch (testOperation) {
                    case "acc" -> testPosition++;
                    case "jmp" -> testPosition += testAmount;
                    case "nop" -> testPosition++;
                }

                if (testPosition >= instructions.size()) {
                    switch (instruction.operation) {
                        case "nop" -> instruction.operation = "jmp";
                        case "jmp" -> instruction.operation = "nop";
                    }
                    found = true;
                    break;
                }

                testOperation = instructions.get(testPosition).getOperation();
                testAmount = instructions.get(testPosition).getAmount();
            }

            switch (instruction.operation) {
                case "acc" -> {
                    answer += instruction.amount;
                    currentPosition++;
                }
                case "jmp" -> currentPosition += instruction.amount;
                case "nop" -> currentPosition++;
            }
            instruction.executed = true;

        } while (currentPosition < instructions.size());

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }


    private static class Instruction {
        String operation;
        Integer amount;
        Boolean executed;

        public Instruction(String operation, Integer amount, Boolean executed) {
            this.operation = operation;
            this.amount = amount;
            this.executed = executed;
        }

        public String getOperation() {
            return operation;
        }

        public Integer getAmount() {
            return amount;
        }

    }
}

