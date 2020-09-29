
package fortressfinderheuristics;

import java.util.*;

public class Position {

    private static HashMap<Integer, Position> positions = new HashMap<Integer, Position>();

    private static final Position[] offsets = {Position.get(-1, 0), Position.get(1, 0), Position.get(0, -1), Position.get(0, 1)};

    

    public int x;
    public int z;


    private Position(int x, int z) {

        this.x = x;
        this.z = z;
    }

    public static Position get(int x, int z) {

        Position position = new Position(x, z);

        if (positions.containsKey(position.hashCode())) {

            position = positions.get(position.hashCode());
        }

        positions.put(position.hashCode(), position);

        return position;
    }

    public Position[] neighbours() {

        Position[] neighbours = new Position[4];
        int index = 0;

        for (Position offset : offsets) {
            int neighbourX = this.x + offset.x;
            int neighbourZ = this.z + offset.z;

            Position neighbour = Position.get(neighbourX, this.z);
            neighbours[index++] = neighbour;
        }

        
       

        return neighbours;
    }

    public boolean fromMatrix(boolean[][] matrix) {

        int origin = matrix.length / 2;

        int xInd = origin + x;
        int zInd = origin + z;

        return matrix[xInd][zInd];
    }

    public double pythagorean() {

        int xDist = Settings.world.spawn.x - x;
        int zDist = Settings.world.spawn.z - z;

        return Math.sqrt(xDist * xDist + zDist * zDist);
    }

    public String toString() {

        return x + " " + z;
    }

    @Override
    public int hashCode() {

        int absX = x + 128;

        int absZ = z + 128;

        int a = absX << 14;

        a += absZ;

        return a;
    }

    public boolean equals(Position pos) {

        if (this.x == pos.x) {

            if (this.z == pos.z) {

                return true;
            }
        }

        return false;
    }
}