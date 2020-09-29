package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

public class North extends Algorithm {

    protected void updatePos() {

        curPos.z--;
    }
}