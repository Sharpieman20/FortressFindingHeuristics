package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

public class West extends Algorithm {

    protected void updatePos() {

        curPos.x--;
    }
}