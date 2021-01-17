package AoC2020.Day11;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatingSystem {
    public static void runDay() throws IOException {
        System.out.println("2020 - Day 11 *********************");
        List<String> rows = LoadFile.LoadStrings("src/main/java/AoC2020/Day11/seats.txt");

        Integer rowLength = rows.get(0).length();
        List<Position> positions = new ArrayList<>();
        for (String row : rows) {
            for (char character : row.toCharArray()) {
                if (character == 'L') {
                    positions.add(new Position(true, 0, false));
                } else {
                    positions.add(new Position(false, 0, false));
                }
            }
        }


        Part1(positions, rowLength, rows.size());//Part 1
        Part2(positions, rowLength);//Part 2
    }

    public static void Part1(List<Position> positions, Integer rowLength, Integer rows) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;
        boolean changed;

        //Refresh updatedPositions list to hold most current - Deep Copy
        List<Position> updatedPositions = new ArrayList<>();
        positions.forEach(position -> {
            updatedPositions.add(new Position(position));
        });



        do {
            changed = false;

            for (int i = 0; i < positions.size(); i++) {
                Position position = positions.get(i);
                Position updatedPosition = updatedPositions.get(i);

                //Sit if a seat and less than 4 adjacent occupants

                if (!position.isSeat()) {
                    continue;
                }

                if (position.isSeat() && position.getAdjacentOccupied() == 0 && !position.isOccupied()) {
                    updatedPosition.setOccupied(true);
                    changed = true;
                }

                if (position.isSeat() && position.getAdjacentOccupied() >= 4 && position.isOccupied()) {
                    updatedPosition.setOccupied(false);
                    changed = true;
                }

            }

            //copy updated to full list
            for (int i = 0; i < updatedPositions.size(); i++) {
                updatedPositions.get(i).setAdjacentOccupied(countAdjacentOccupied(updatedPositions, i, rowLength, rows));
                positions.set(i, new Position(updatedPositions.get(i)));
            }

        } while (changed);


        answer = (int) positions.stream().filter(Position::isOccupied).count();

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static Integer countAdjacentOccupied(List<Position> updatedPositions, Integer index, Integer rowLength, Integer rows) {
        Integer count = 0;

        int totalSize = rowLength * rows;

        boolean top = index - rowLength >= 0;
        boolean left = index % rowLength != 0;
        boolean right = (index + 1) % rowLength != 0;
        boolean bottom = index + rowLength < totalSize;

        boolean topLeft = ((index - rowLength - 1) >= 0) && (index % rowLength != 0);
        boolean topRight = (index - rowLength + 1) >= 0 && ((index + 1) % rowLength != 0);
        boolean botLeft = (index + rowLength - 1) < totalSize && (index % rowLength != 0);
        boolean botRight = (index + rowLength + 1) < totalSize && ((index + 1) % rowLength != 0);

        if (top) {
            if (updatedPositions.get(index - rowLength).isOccupied()) {
                count++;
            }
        }

        if (left) {
            if (updatedPositions.get(index - 1).isOccupied()) {
                count++;
            }
        }

        if (right) {
            if (updatedPositions.get(index + 1).isOccupied()) {
                count++;
            }
        }

        if (bottom) {
            if (updatedPositions.get(index + rowLength).isOccupied()) {
                count++;
            }
        }

        if (topLeft) {
            if (updatedPositions.get(index - rowLength - 1).isOccupied()) {
                count++;
            }
        }

        if (topRight) {
            if (updatedPositions.get(index - rowLength + 1).isOccupied()) {
                count++;
            }
        }

        if (botLeft) {
            if (updatedPositions.get(index + rowLength - 1).isOccupied()) {
                count++;
            }
        }

        if (botRight) {
            if (updatedPositions.get(index + rowLength + 1).isOccupied()) {
                count++;
            }
        }

        return count;
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
