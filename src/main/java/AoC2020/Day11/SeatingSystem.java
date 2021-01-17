package AoC2020.Day11;

import Utils.LoadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeatingSystem {
    private static Integer rowLength;
    private static Integer totalSize;

    public static void runDay() throws IOException {
        System.out.println("2020 - Day 11 *********************");

        Part1(loadRows());//Part 1
        Part2(loadRows());//Part 2
    }

    public static List<Position> loadRows() throws IOException {
        List<String> rowsList = LoadFile.LoadStrings("src/main/java/AoC2020/Day11/seats.txt");

        rowLength = rowsList.get(0).length();
        totalSize = rowLength * rowsList.size();

        List<Position> positions = new ArrayList<>();
        for (String row : rowsList) {
            for (char character : row.toCharArray()) {
                if (character == 'L') {
                    positions.add(new Position(true, 0, false));
                } else {
                    positions.add(new Position(false, 0, false));
                }
            }
        }

        return positions;
    }

    public static void Part1(List<Position> positions) {
        System.out.println("Part 1:");
        long start = System.nanoTime();

        int answer;
        boolean changed;

        //Refresh updatedPositions list to hold most current - Deep Copy
        List<Position> updatedPositions = new ArrayList<>();
        positions.forEach(position -> updatedPositions.add(new Position(position)));


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
                updatedPositions.get(i).setAdjacentOccupied(countAdjacentOccupied(updatedPositions, i, false));
                positions.set(i, new Position(updatedPositions.get(i)));
            }

        } while (changed);


        answer = (int) positions.stream().filter(Position::isOccupied).count();

        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }

    public static Integer countAdjacentOccupied(List<Position> positions, Integer index, Boolean lookPastFloor) {
        int count = 0;

        count += checkTop(positions, index, lookPastFloor);
        count += checkLeft(positions, index, lookPastFloor);
        count += checkRight(positions, index, lookPastFloor);
        count += checkBottom(positions, index, lookPastFloor);
        count += checkTopLeft(positions, index, lookPastFloor);
        count += checkTopRight(positions, index, lookPastFloor);
        count += checkBottomLeft(positions, index, lookPastFloor);
        count += checkBottomRight(positions, index, lookPastFloor);

        return count;
    }

    private static Integer checkTop(List<Position> positions, Integer index, Boolean lookPast) {
        boolean top = index - rowLength >= 0;
        int topIndex = index - rowLength;

        if (top) {
            if (lookPast && positions.get(topIndex).isFloor()) {
                return checkTop(positions, topIndex, true);
            }

            if (positions.get(topIndex).isOccupied()) {
                return 1;
            }
        }

        return 0;
    }

    private static Integer checkLeft(List<Position> positions, Integer index, Boolean lookPast) {
        boolean left = index % rowLength != 0;
        int leftIndex = index - 1;

        if (left) {
            if (lookPast && positions.get(leftIndex).isFloor()) {
                return checkLeft(positions, leftIndex, true);
            }

            if (positions.get(index - 1).isOccupied()) {
                return 1;
            }
        }
        return 0;
    }

    private static Integer checkRight(List<Position> positions, Integer index, Boolean lookPast) {
        boolean right = (index + 1) % rowLength != 0;
        int rightIndex = index + 1;

        if (right) {
            if (lookPast && positions.get(rightIndex).isFloor()) {
                return checkRight(positions, rightIndex, true);
            }

            if (positions.get(rightIndex).isOccupied()) {
                return 1;
            }
        }
        return 0;
    }

    private static Integer checkBottom(List<Position> positions, Integer index, Boolean lookPast) {
        boolean bottom = index + rowLength < totalSize;
        int botIndex = index + rowLength;

        if (bottom) {
            if (lookPast && positions.get(botIndex).isFloor()) {
                return checkBottom(positions, botIndex, true);
            }

            if (positions.get(botIndex).isOccupied()) {
                return 1;
            }
        }

        return 0;
    }

    private static Integer checkTopLeft(List<Position> positions, Integer index, Boolean lookPast) {
        boolean topLeft = ((index - rowLength - 1) >= 0) && (index % rowLength != 0);
        int topLeftIndex = index - rowLength - 1;

        if (topLeft) {
            if (lookPast && positions.get(topLeftIndex).isFloor()) {
                return checkTopLeft(positions, topLeftIndex, true);
            }

            if (positions.get(topLeftIndex).isOccupied()) {
                return 1;
            }
        }

        return 0;
    }

    private static Integer checkTopRight(List<Position> positions, Integer index, Boolean lookPast) {
        boolean topRight = ((index - rowLength + 1) >= 0) && ((index + 1) % rowLength != 0);
        int topRightIndex = index - rowLength + 1;

        if (topRight) {

            if (lookPast && positions.get(topRightIndex).isFloor()) {
                return checkTopRight(positions, topRightIndex, true);
            }

            if (positions.get(index - rowLength + 1).isOccupied()) {
                return 1;
            }
        }

        return 0;
    }

    private static Integer checkBottomLeft(List<Position> positions, Integer index, Boolean lookPast) {
        boolean botLeft = (index + rowLength - 1) < totalSize && (index % rowLength != 0);
        int botLeftIndex = index + rowLength - 1;

        if (botLeft) {

            if (lookPast && positions.get(botLeftIndex).isFloor()) {
                return checkBottomLeft(positions, botLeftIndex, true);
            }

            if (positions.get(botLeftIndex).isOccupied()) {
                return 1;
            }
        }

        return 0;
    }

    private static Integer checkBottomRight(List<Position> positions, Integer index, Boolean lookPast) {
        boolean botRight = (index + rowLength + 1) < totalSize && ((index + 1) % rowLength != 0);
        int botRightIndex = index + rowLength + 1;

        if (botRight) {

            if (lookPast && positions.get(botRightIndex).isFloor()) {
                return checkBottomRight(positions, botRightIndex, true);
            }

            if (positions.get(index + rowLength + 1).isOccupied()) {
                return 1;
            }

        }

        return 0;
    }


    public static void Part2(List<Position> positions) {
        System.out.println("Part 2:");
        long start = System.nanoTime();

        int answer;
        boolean changed;

        //Refresh updatedPositions list to hold most current - Deep Copy
        List<Position> updatedPositions = new ArrayList<>();
        positions.forEach(position -> updatedPositions.add(new Position(position)));

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

                if (position.isSeat() && position.getAdjacentOccupied() >= 5 && position.isOccupied()) {
                    updatedPosition.setOccupied(false);
                    changed = true;
                }

            }

            //copy updated to full list
            for (int i = 0; i < updatedPositions.size(); i++) {
                updatedPositions.get(i).setAdjacentOccupied(countAdjacentOccupied(updatedPositions, i, true));
                positions.set(i, new Position(updatedPositions.get(i)));
            }

        } while (changed);


        answer = (int) positions.stream().filter(Position::isOccupied).count();


        System.out.println("Answer: " + answer);

        long finish = System.nanoTime();
        long delta = finish - start;
        System.out.println("Total Time: " + delta + "ns");
    }
}
