package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;

public abstract class Algorithm {

    Position curPos;
    

    public abstract Position getNextPos();

    public void giveResult(boolean result) {

    }

    public void setPos(Position pos) {

        curPos = pos;
    }
}