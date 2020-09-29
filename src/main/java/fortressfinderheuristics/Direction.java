package fortressfinderheuristics;

public enum Direction {
    North,
    South,
    East,
    West;

    public Direction[] getPerpendicular() {

        Direction[] perpendiculars = new Direction[2];

        if (this.equals(Direction.North) || this.equals(Direction.South)) {

            perpendiculars[0] = Direction.East;
            perpendiculars[1] = Direction.West;
        } else {

            perpendiculars[0] = Direction.North;
            perpendiculars[1] = Direction.South;
        }

        return perpendiculars;
    }
}
