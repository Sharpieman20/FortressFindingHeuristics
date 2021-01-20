

package fortressfinderheuristics;

import fortressfinderheuristics.algorithms.*;

public class Tester {
    public static int scoreAlgorithm(Algorithm algo) {

        Nether nether = Settings.world.nether;

        // boolean[][] fortMatrix = nether.searchAroundOrigin();

        int dist = 0;

        boolean didFind = false;
        // System.out.println("-----------------------------");

        while(dist < Settings.SEARCH_DEPTH && !nether.hasStructureInRegion(algo.curPos)) {

            // System.out.println(algo.curPos);

            dist++;

            algo.doStep();
        }

        // System.out.println(algo.curPos);

        // dist *= 2;

        // System.out.println("dist " + dist);
        // System.out.println("-----------------------------");

        return dist;
    }
}