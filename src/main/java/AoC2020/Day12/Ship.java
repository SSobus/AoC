package AoC2020.Day12;

import java.awt.*;

public class Ship {

    Integer northSouth;
    Integer eastWest;
    Direction direction;
    Integer rotation;
    Point waypoint;

    public Ship() {
        direction = Direction.EAST;
        northSouth = 0;
        eastWest = 0;
        rotation = 90;

        waypoint = new Point(10, 1);
    }

    public void move(Integer distance) {
        switch (direction) {
            case NORTH -> northSouth += distance;
            case EAST -> eastWest += distance;
            case SOUTH -> northSouth -= distance;
            case WEST -> eastWest -= distance;
        }
    }

    public void move(Direction direction, Integer distance) {
        switch (direction) {
            case NORTH -> northSouth += distance;
            case EAST -> eastWest += distance;
            case SOUTH -> northSouth -= distance;
            case WEST -> eastWest -= distance;
        }
    }

    public void rotate(Turn turn, Integer amount) {
        switch (turn) {
            case RIGHT -> rotation += amount;
            case LEFT -> rotation -= amount;
        }

        if (rotation >= 360) {
            rotation -= 360;
        } else if (rotation < 0) {
            rotation += 360;
        }

        switch (rotation) {
            case 90 -> direction = Direction.EAST;
            case 180 -> direction = Direction.SOUTH;
            case 270 -> direction = Direction.WEST;
            case 0 -> direction = Direction.NORTH;
        }
    }

    public void rotateWaypoint(Turn turn, Integer amount) {
        int turns = amount / 90;

        for (int i = 0; i < turns; i++) {
            switch (turn) {
                case RIGHT -> waypoint.setLocation(waypoint.getY(), -waypoint.getX());
                case LEFT -> waypoint.setLocation(-waypoint.getY(), waypoint.getX());
            }
            rotate(turn, amount);
        }

    }

    public void moveWaypoint(Direction direction, Integer distance) {
        switch (direction) {
            case NORTH -> waypoint.y += distance;
            case EAST -> waypoint.x += distance;
            case SOUTH -> waypoint.y -= distance;
            case WEST -> waypoint.x -= distance;
        }
    }

    public void moveToWaypoint(Integer amount) {
        northSouth += ((int) waypoint.getX()) * amount;
        eastWest += ((int) waypoint.getY()) * amount;
    }

    public Integer getManhattanDistance() {
        return Math.abs(northSouth) + Math.abs(eastWest);
    }

    enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    enum Turn {
        RIGHT,
        LEFT
    }
}


