package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;

public abstract class Algorithm {

    public Position prevPos;
    public Position curPos;
    
    public void reset(Position startPos) {

        // System.out.println("Starting at " + startPos);

        this.curPos = startPos;
    }

    protected abstract void updatePos();

    public void doStep() {

        int prevX = curPos.x;
        int prevZ = curPos.z;

        // prevPos = Position.get(prevX, prevZ);

        updatePos();

        int newX = curPos.x;
        int newZ = curPos.z;

        curPos.x = prevX;
        curPos.z = prevZ;

        // System.out.println("STEP");

        curPos = Position.get(newX, newZ);
    }

    public boolean usesPositionDatabase() {

        return false;
    }

    public void giveResult(boolean result) {

    }

    public void setPos(Position pos) {

        curPos = pos;
    }
}