package fortressfinderheuristics.algorithms.directional;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;
import fortressfinderheuristics.algorithms.Algorithm;

public class EastUnlessQuadrant extends Algorithm {
    protected void updatePos() {

        if (curPos.x <= -1 && curPos.z == 0) {

            curPos.x--;
        } else {

            curPos.x++;
        }
    }
}