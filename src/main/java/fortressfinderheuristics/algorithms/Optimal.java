package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

import java.util.*;

public class Optimal extends Algorithm {

    HashSet<Position> visited;

    int step = 1;

    public void setPos(Position pos) {

        super.setPos(pos);

        visited = new HashSet<Position>();
    }

    public Position getNextPos() {

        return null;
    }

        

    //     double min = Double.Infinity;



    //     visited.add(curPos);

    //     if (curPos.x >= 0 && curPos.z >= 0) {

    //         curPos.z -= 1;

    //         if (visited.contains(curPos)) {

    //             curPos.x += 1;
    //         }
    //     } else if (curPos.x >= 0 && curPos.z <= -1) {

    //         curPos.z += 1;

    //         if (visited.contains(curPos)) {

    //             curPos.x += 1;
    //         }
    //     } else if (curPos.x <= -1 && curPos.z >= 0) {

    //         curPos.z -= 1;

    //         if (visited.contains(curPos)) {

    //             curPos.x -= 1;
    //         }
    //     } else if (curPos.x <= -1 && curPos.z <= -1) {

    //         curPos.z += 1;

    //         if (visited.contains(curPos)) {

    //             curPos.x -= 1;
    //         }
    //     }

        

    //     return curPos;
    // }

    // private double getCostAtPos(Position pos) {

    //     if (nether.checkIfInRegion(pos)) {

    //         return 0.0;
    //     }

    //     if (visited.size() > Settings.MAX_SEARCH_DIST) {

    //         // Should be infinity but that would throw off our average
    //         return Settings.MAX_SEARCH_DIST;
    //     }

    //     visited.add(pos);

    //     Position offsets = [Position(-1, 0), Position(1, 0), Position(0, -1), Position(0, 1)];

    //     double minCost = Double.Infinity;

    //     for (Position offset : offsets) {

    //         double cost = 1 + getCostAtPos(pos);

    //         if (cost < minCost) {

    //             minCost = cost;
    //         }
    //     }

    //     visited.remove(pos);

    //     return minCost;
    // }
}