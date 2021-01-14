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

        List<Position> updatedPositions = new ArrayList<>();

        positions.forEach(position -> {
            updatedPositions.add(new Position(position));
        });

        int totalSize = rowLength * rows;

        do {
            changed = false;

            for (int i = 0; i < positions.size(); i++) {
                Position position = updatedPositions.get(i);

                //Sit if a seat and less than 4 adjacent occupants

                boolean topLeft = ((i - rowLength - 1) >= 0) && (i % rowLength != 0);
                boolean top = i - rowLength >= 0;
                boolean topRight = (i - rowLength + 1) >= 0 && ((i + 1) % rowLength != 0);
                boolean left = i % rowLength != 0;
                boolean right = (i + 1) % rowLength != 0;
                boolean botLeft = (i + rowLength - 1) < totalSize && (i % rowLength != 0);
                boolean bottom = i + rowLength < totalSize;
                boolean botRight = (i + rowLength + 1) < totalSize && ((i + 1) % rowLength != 0);

                if (!positions.get(i).isSeat()) {
                    continue;
                }

                if (positions.get(i).isSeat() && positions.get(i).getAdjacentOccupied() < 4) {
                    position.setOccupied(true);
                    changed = true;
                }

                if (positions.get(i).isSeat() && positions.get(i).getAdjacentOccupied() >= 4) {
                    position.setOccupied(false);
                    changed = true;
                }

                //Find Neighbours and update
                if (top) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i - rowLength).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i - rowLength).removeAdjacentOccupant();
                    }
                }

                if (left) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i - 1).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i - 1).removeAdjacentOccupant();
                    }
                }

                if (right) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i + 1).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i + 1).removeAdjacentOccupant();
                    }
                }

                if (bottom) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i + rowLength).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i + rowLength).removeAdjacentOccupant();
                    }
                }

                if (topLeft) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i - rowLength - 1).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i - rowLength - 1).removeAdjacentOccupant();
                    }
                }

                if (topRight) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i - rowLength + 1).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i - rowLength + 1).removeAdjacentOccupant();
                    }
                }

                if (botLeft) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i + rowLength - 1).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i + rowLength - 1).removeAdjacentOccupant();
                    }
                }

                if (botRight) {
                    if (position.getOccupied()) {
                        updatedPositions.get(i + rowLength + 1).addAdjacentOccupant();
                    } else {
                        updatedPositions.get(i + rowLength + 1).removeAdjacentOccupant();
                    }
                }
            }

            //copy updated to full list
            for (int i = 0; i < updatedPositions.size(); i++) {
                positions.set(i, new Position(updatedPositions.get(i)));
            }

        } while (changed);


        answer = (int) positions.stream().filter(Position::getOccupied).count();

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
