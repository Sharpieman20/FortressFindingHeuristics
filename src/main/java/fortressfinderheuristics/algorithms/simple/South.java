package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

public class South extends Algorithm {

    protected void updatePos() {

        curPos.z++;
    }
}