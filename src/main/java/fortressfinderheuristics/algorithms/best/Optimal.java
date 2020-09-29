package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;
import fortressfinderheuristics.database.PositionDatabase;

import java.util.*;
import java.lang.Double.*;

public class Optimal extends Algorithm {

    

    HashSet<Position> visited;

    public void reset(Position startPos) {

        super.reset(startPos);

        visited = new HashSet<Position>();   
    }

    public void setPos(Position pos) {

        super.setPos(pos);
    }

    @Override
    public boolean usesPositionDatabase() {

        return true;
    }

    protected void updatePos() {

        visited.add(curPos);

        double lowestCost = Double.POSITIVE_INFINITY;
        Position nextPos = Position.get(curPos.x, curPos.z);

        for (Position neighbour : curPos.neighbours()) {

            double cost = getCostAtPos(neighbour);

            if (cost < lowestCost) {
                nextPos = neighbour;
                lowestCost = cost;
            }
        }

        curPos.x = nextPos.x;
        curPos.z = nextPos.z;
    }

    private double getCostAtPos(Position pos) {

        double myCost = Double.POSITIVE_INFINITY;

        if (visited.contains(pos)) {

            return myCost;
        }

        if (visited.size() > Settings.SEARCH_DEPTH) {

            // Should be infinity but that would throw off our average
            return Settings.SEARCH_DEPTH;
        }



        // System.out.println("not visited");

        

        double chanceContainsFortress = PositionDatabase.get(visited, pos);

        visited.add(pos);

        double minCost = myCost;

        for (Position neighbour : pos.neighbours()) {

            double cost = 1 + getCostAtPos(neighbour);

            if (cost < minCost) {

                minCost = cost;
            }
        }

        myCost = minCost * (1 - chanceContainsFortress);

        visited.remove(pos);
    




        return myCost;
    }
}