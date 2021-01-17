package AoC2020.Day12;

import Utils.LoadFile;

import java.io.IOException;
import java.util.List;

public class RainRisk {

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 12 *********************");
        List<String> movement = LoadFile.LoadStrings("src/main/java/AoC2020/Day12/movement.txt");

        Part1(movement);//Part 1
        Part2(movement);//Part 2
    }

    public static void Part1(List<String> movement) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;
        Ship ship = new Ship();

        for (String command : movement) {
            String type = command.substring(0, 1);
            Integer amount = Integer.parseInt(command.substring(1));

            switch (type) {
                case "F" -> ship.move(amount);
                case "N" -> ship.move(Ship.Direction.NORTH, amount);
                case "E" -> ship.move(Ship.Direction.EAST, amount);
                case "S" -> ship.move(Ship.Direction.SOUTH, amount);
                case "W" -> ship.move(Ship.Direction.WEST, amount);
                case "R" -> ship.rotate(Ship.Turn.RIGHT, amount);
                case "L" -> ship.rotate(Ship.Turn.LEFT, amount);
            }
        }

        answer = ship.getManhattanDistance();

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<String> movement) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int answer;

        Ship ship = new Ship();

        for (String command : movement) {
            String type = command.substring(0, 1);
            Integer amount = Integer.parseInt(command.substring(1));

            switch (type) {
                case "F" -> ship.moveToWaypoint(amount);
                case "N" -> ship.moveWaypoint(Ship.Direction.NORTH, amount);
                case "E" -> ship.moveWaypoint(Ship.Direction.EAST, amount);
                case "S" -> ship.moveWaypoint(Ship.Direction.SOUTH, amount);
                case "W" -> ship.moveWaypoint(Ship.Direction.WEST, amount);
                case "R" -> ship.rotateWaypoint(Ship.Turn.RIGHT, amount);
                case "L" -> ship.rotateWaypoint(Ship.Turn.LEFT, amount);
            }
        }

        answer = ship.getManhattanDistance();
        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
