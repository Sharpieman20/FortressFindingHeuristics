package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

import java.util.*;

public class SwitchZEastWest extends Algorithm {

    HashSet<Position> visited;

    int step = 1;

    public void setPos(Position pos) {

        super.setPos(pos);

        visited = new HashSet<Position>();
    }

    public Position getNextPos() {

        visited.add(curPos);

        if (curPos.x >= 0 && curPos.z >= 0) {

            curPos.z -= 1;

            if (visited.contains(curPos)) {

                curPos.x += 1;
            }
        } else if (curPos.x >= 0 && curPos.z <= -1) {

            curPos.z += 1;

            if (visited.contains(curPos)) {

                curPos.x += 1;
            }
        } else if (curPos.x <= -1 && curPos.z >= 0) {

            curPos.z -= 1;

            if (visited.contains(curPos)) {

                curPos.x -= 1;
            }
        } else if (curPos.x <= -1 && curPos.z <= -1) {

            curPos.z += 1;

            if (visited.contains(curPos)) {

                curPos.x -= 1;
            }
        }

        

        return curPos;
    }
}