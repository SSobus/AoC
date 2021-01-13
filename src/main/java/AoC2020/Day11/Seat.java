package AoC2020.Day11;

public class Seat extends Position {

    private Boolean isOccupied;

    public Seat() {
        super.setAdjacentOccupied(0);
    }

    public Seat(Seat clone) {
        super.setAdjacentOccupied(clone.getAdjacentOccupied());
        this.isOccupied = clone.isOccupied;
    }

    public Boolean getOccupied() {
        return isOccupied;
    }

    public void setOccupied(Boolean occupied) {
        isOccupied = occupied;
    }

}
