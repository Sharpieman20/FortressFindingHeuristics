package fortressfinderheuristics;

import java.util.*;

public class PositionInfoStore {

    protected final int minValue;

    public PositionInfoStore(int minValue) {

        this.minValue = minValue - 1;
    }

    public ArrayList<Position> exploreAll() {

        ArrayList<Position> positions = new ArrayList<Position>();

        int xBound = Math.abs(minValue);

        for (int x = -xBound; x < xBound; x++) {

            int zBound = Math.abs(minValue) - Math.abs(x);

            for (int z = -zBound; z < zBound; z++) {

                positions.add(Position.get(x, z));
            }
        }

        return positions;
    }

    public int getSize() {

        return Math.abs(minValue * 2) + 1;
    }

    public int convertXToIndex(int x) {

        return x - minValue;
    }

    public int convertIndexToX(int index) {

        return index + minValue;
    }

    public int convertZToIndex(int z) {

        return z - minValue;
    }

    public int convertIndexToZ(int index) {

        return index + minValue;
    }
}