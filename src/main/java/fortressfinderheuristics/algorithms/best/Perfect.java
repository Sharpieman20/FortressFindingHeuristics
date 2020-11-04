package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

import java.util.*;
import java.lang.Double;

public class Perfect extends Algorithm {

    HashMap<Position, Double> searchCosts;
    HashSet<Position> visited;
    // boolean hasFoundFortress

    public void reset(Position startPos) {

        super.reset(startPos);

        visited = new HashSet<Position>();

        // System.out.println("------------");
    }

    protected void updatePos() {

        // return null;

        Position nextPos = curPos;

        double minCost = Double.POSITIVE_INFINITY;

        searchCosts = new HashMap<Position, Double>();

        visited.add(curPos);

        for (Position pos : curPos.neighbours()) {

            double cost = getCostAtPos(pos);

            if (cost < minCost) {

                minCost = cost;
                nextPos = pos;
            }
        }

        curPos.x = nextPos.x;
        curPos.z = nextPos.z;
    }

    private double getCostAtPos(Position pos) {

        if (visited.contains(pos)) {

            return Double.POSITIVE_INFINITY;
        }

        if (visited.size() >= Settings.SEARCH_DEPTH) {

            // Should be infinity but that would throw off our average
            return Settings.SEARCH_DEPTH;
        }

        if (searchCosts.containsKey(pos)) {

            return searchCosts.get(pos);
        }

        double myCost = 0.0;

        // System.out.println("START " + visited + " " + pos);

        if (!Settings.world.nether.hasStructureInRegion(pos)) {

            visited.add(pos);

            double minCost = Double.POSITIVE_INFINITY;

            for (Position offset : pos.neighbours()) {

                double cost = 1 + getCostAtPos(offset);

                if (cost < minCost) {

                    minCost = cost;
                }
            }

            visited.remove(pos);

            myCost = minCost;
        }

        // System.out.println("ENDDD " + visited + " " + pos);

        searchCosts.put(pos, myCost);

        return myCost;
    }
}