package AoC2020.Day11;

public class Floor extends Position {

    public Floor() {
        super.setAdjacentOccupied(0);
    }

    public Floor(Floor clone) {
        super.setAdjacentOccupied(clone.getAdjacentOccupied());
    }

}
