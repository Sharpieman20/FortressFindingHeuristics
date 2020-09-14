
package fortressfinderheuristics;

import java.util.*;

public class Position {

    public int x;
    public int z;

    public Position(int x, int z) {

        this.x = x;
        this.z = z;
    }

    public boolean fromMatrix(boolean[][] matrix) {

        int origin = matrix.length / 2;

        // System.out.println(x);
        // System.out.println(z);

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

        int absX = x;

        if (absX < 0) {
            x += 16 * 16 * 16;
        }     

        int absZ = x;

        if (absZ < 0) {
            absZ += 16 * 16 * 16;
        }        

        int a = absX << 14;
        a += absZ << 14;

        return a;
    }

    public boolean equals(Position pos) {

        return this.hashCode() == pos.hashCode();
    }
}