

package fortressfinderheuristics;

import fortressfinderheuristics.algorithms.*;

public class Tester {
    public static double scoreAlgorithm(Algorithm algo) {

        Nether nether = Settings.world.nether;

        // boolean[][] fortMatrix = nether.searchAroundOrigin();

        double dist = -1;

        boolean didFind = false;

        Position pos = Settings.world.getSpawn();

        

        algo.setPos(pos);

        do {

            didFind = nether.checkIfInRegion(pos);

            algo.giveResult(didFind);

            pos = algo.getNextPos();

            // System.out.println(pos);

            dist++;

        } while(!didFind);

        dist *= 2;

        return dist;
    }
}