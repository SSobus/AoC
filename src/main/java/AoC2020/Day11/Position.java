package AoC2020.Day11;

public class Position {

    private final Boolean isSeat;

    private Integer adjacentOccupied;

    private Boolean isOccupied;

    public Position(Boolean isSeat, Integer adjacentOccupied, Boolean isOccupied) {
        this.isSeat = isSeat;
        this.adjacentOccupied = adjacentOccupied;
        this.isOccupied = isOccupied;
    }

    public Position(Position clone) {
        this.isSeat = clone.isSeat;
        this.adjacentOccupied = clone.adjacentOccupied;
        this.isOccupied = clone.isOccupied;
    }

    public Boolean isSeat() {
        return isSeat;
    }

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

    public Boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }
}
