package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

public class EastSouth extends Algorithm {

    int step = 1;
    String direction;

    public void setPos(Position pos) {

        super.setPos(pos);

        step = (int) Math.abs(Settings.rand.nextLong()) % 2;
        step--;

        if (step == 0) {
            direction = "South";
        } else {
            direction = "East";
        }

        step = 1;
    }

    protected void updatePos() {

        int direction = (int) (Math.random() * 2);

        if (direction == 0) {

            curPos.x++;
        } else if (direction == 1) {

            curPos.z++;
        } else {

            throw new IllegalStateException();
        }
    }
}