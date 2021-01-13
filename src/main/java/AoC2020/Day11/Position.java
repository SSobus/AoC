package AoC2020.Day11;

public class Position {

    private Integer adjacentOccupied;

    public void addAdjacentOccupant() {
        adjacentOccupied++;
    }

    public void removeAdjacentOccupant() {
        adjacentOccupied--;
    }

    public Integer getAdjacentOccupied() {
        return adjacentOccupied;
    }

    public void setAdjacentOccupied(Integer adjacentOccupied) {
        this.adjacentOccupied = adjacentOccupied;
    }
}
