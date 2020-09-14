package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

public class EastWest extends Algorithm {

    int step = 1;

    public void setPos(Position pos) {

        super.setPos(pos);

        step = (int) Math.abs(Settings.rand.nextLong()) % 2;
        step--;

        if (step == 0) {
            step++;
        }
    }

    public Position getNextPos() {

        curPos.x += step;

        return curPos;
    }
}