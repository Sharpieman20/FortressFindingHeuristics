// GEN

package fortressfinderheuristics.database;

import kaptainwutax.featureutils.structure.Fortress;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;
import fortressfinderheuristics.World;
import fortressfinderheuristics.PositionInfoStore;

import java.util.*;

public class PositionDatabase {

    static PositionInfoStore posConverter;

    static boolean[][][] fortressLocations;

    static HashMap<HashSet<Position>, HashMap<Position,Double>> queryHistory;

    public static void initialize() {
        posConverter = new PositionInfoStore(-Settings.SEARCH_DEPTH);

        int size = posConverter.getSize();

        fortressLocations = new boolean[Settings.NUM_INIT_LOOPS][size][size];

        queryHistory = new HashMap<HashSet<Position>, HashMap<Position,Double>>();

        for (int w = 0; w < Settings.NUM_INIT_LOOPS; w++) {

            World world = new World();

            int xBound = Settings.SEARCH_DEPTH;

            for (int x = -xBound; x <= xBound; x++) {

                int zBound = Settings.SEARCH_DEPTH - Math.abs(x);

                for (int z = -zBound; z <= zBound; z++) {

                    int i = posConverter.convertXToIndex(x);
                    int j = posConverter.convertZToIndex(z);

                    fortressLocations[w][i][j] = world.nether.hasStructureInRegion(x, z);
                }
            }
        }
    }

    

    public static double get(HashSet<Position> visited, Position curPos) {

        if (queryHistory.containsKey(visited)) {

            HashMap<Position, Double> costsForCurPos = queryHistory.get(visited);

            if (costsForCurPos.containsKey(curPos)) {

                return costsForCurPos.get(curPos);
            }
        }

        int denom = 0;
        int count = 0;

        boolean foundMatch = false;

        for (int i = 0; i < fortressLocations.length; i++) {

            boolean doesMatch = true;

            for (Position pos : visited) {

                int xIndex = posConverter.convertXToIndex(pos.x);
                int zIndex = posConverter.convertZToIndex(pos.z);

                if (fortressLocations[i][xIndex][zIndex]) {
                    doesMatch = false;
                    break;
                }
            }

            if (doesMatch) {

                denom++;

                foundMatch = true;

                int xIndex = posConverter.convertXToIndex(curPos.x);
                int zIndex = posConverter.convertZToIndex(curPos.z);

                if (fortressLocations[i][xIndex][zIndex]) {

                    count++;
                }
            }
        }

        double myCost = 0.0;

        if (foundMatch) {

            myCost = ((double)count)/denom;

            // throw new IllegalStateException("0 matches for position " + visited);
        }

        

        if (!queryHistory.containsKey(visited)) {

            HashSet<Position> clonedVisited = new HashSet<Position>();

            for (Position oldPos : visited) {

                clonedVisited.add(oldPos);
            }

            queryHistory.put(clonedVisited, new HashMap<Position, Double>());
        }

        HashMap<Position, Double> costsForCurPos = queryHistory.get(visited);

        costsForCurPos.put(curPos, myCost);

        return myCost;
    }
}


// GET

