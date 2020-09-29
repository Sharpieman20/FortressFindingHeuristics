package fortressfinderheuristics.algorithms.directional;

import fortressfinderheuristics.*;
import fortressfinderheuristics.algorithms.*;

import java.util.*;
import java.lang.*;

public abstract class DirectionalAlgorithm extends LoggingAlgorithm {

    public Direction direction;

    int northCount;
    int eastCount;
    int southCount;
    int westCount;

    protected abstract void updateDirection();

    protected void updatePos() {

        updateDirection();

        if (direction == Direction.North) {

            curPos.z++;
        } else if (direction == Direction.East) {

            curPos.x++;
        } else if (direction == Direction.South) {

            curPos.z--;
        } else if (direction == Direction.West) {

            curPos.x--;
        } else {
            throw new IllegalStateException("Invalid direction " + direction);
        }

        // System.out.println(curPos);

        if (isVisited(curPos)) {
            // redo
            curPos = prevPos;
            doStep();
        } else {

            if (direction == Direction.North) {

                northCount++;
            } else if (direction == Direction.East) {

                eastCount++;
            } else if (direction == Direction.South) {

                southCount++;
            } else if (direction == Direction.West) {

                westCount++;
            } else {
                throw new IllegalStateException("Invalid direction");
            }
        }
    }

    public boolean usesPositionDatabase() {

        return false;
    }

    public void giveResult(boolean result) {

    }

    public void setPos(Position pos) {

        curPos = pos;
    }

    public String toString() {

        int total = northCount + eastCount + southCount + westCount;

        String northCountStr = "North " + String.format("%.2f", ((double)northCount)/total);
        String eastCountStr = "East " + String.format("%.2f", ((double)eastCount)/total);
        String southCountStr = "South " + String.format("%.2f", ((double)southCount)/total);
        String westCountStr = "West " + String.format("%.2f", ((double)westCount)/total);

        return String.join("\n", northCountStr, eastCountStr, southCountStr, westCountStr);
    }
}