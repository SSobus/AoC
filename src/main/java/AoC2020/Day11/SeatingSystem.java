package AoC2020.Day11;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatingSystem {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 11 *********************");
        List<String> rows = LoadFile.LoadStrings("src/main/java/AoC2020/Day11/adapters.txt");

        Integer rowLength = rows.get(0).length();
        List<Position> positions = new ArrayList<>();
        for (String row : rows) {
            for (char character : row.toCharArray()) {
                if (character == 'L') {
                    positions.add(new Seat());
                } else {
                    positions.add(new Floor());
                }
            }
        }


        Part1(positions, rowLength);//Part 1
        Part2(positions, rowLength);//Part 2
    }

    public static void Part1(List<Position> positions, Integer rowLength) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer = 0;

        Boolean changed = false;

        List<Position> updatedPositions = new ArrayList<>();

        positions.forEach(position -> {
            if (position.getClass().equals(Seat.class)) {
                updatedPositions.add(new Seat((Seat) position));
            } else {
                updatedPositions.add(new Floor((Floor) position));
            }
        });


        for (int i = 0; i < positions.size(); i++) {
            Position position = updatedPositions.get(i);
            //Sit if a seat and less than 4 adjacent occupants
            if (position.getClass().equals(Seat.class) && position.getAdjacentOccupied() < 4) {
                ((Seat) position).setOccupied(true);

                //set adjacent counts
                //top left
                if (i - (i * rowLength) - 1 > 0) {
                    updatedPositions.get(i - (i * rowLength) - 1).addAdjacentOccupant();
                }

                //top
                if (i - (i * rowLength) > 0) {
                    updatedPositions.get(i - (i * rowLength)).addAdjacentOccupant();
                }

                //top
                if (i - (i * rowLength) + 1 > 0) {
                    updatedPositions.get(i - (i * rowLength) + 1).addAdjacentOccupant();
                }

                //left
                if (i - 1 > 0) {
                    updatedPositions.get(i - (i * rowLength)).addAdjacentOccupant();
                }
            }


        }


        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static void Part2(List<Position> positions, Integer rowLength) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int answer = 0;


        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
