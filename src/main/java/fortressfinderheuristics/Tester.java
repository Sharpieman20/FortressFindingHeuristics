

package fortressfinderheuristics;

import fortressfinderheuristics.algorithms.*;

public class Tester {
    public static int scoreAlgorithm(Algorithm algo) {

        Nether nether = Settings.world.nether;

        // boolean[][] fortMatrix = nether.searchAroundOrigin();

        int dist = 0;

        boolean didFind = false;

        while(dist < Settings.SEARCH_DEPTH && !nether.hasFortressInRegion(algo.curPos)) {

            dist++;

            algo.doStep();
        }

        dist *= 2;

        return dist;
    }
}