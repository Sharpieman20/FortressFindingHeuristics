package fortressfinderheuristics.algorithms.directional;

import fortressfinderheuristics.*;
import fortressfinderheuristics.algorithms.directional.*;
import fortressfinderheuristics.Settings;

import java.lang.Math;
import java.lang.IllegalStateException;

public class RandomDirection extends DirectionalAlgorithm {

    int ind;
    Direction dir1;
    Direction dir2;

    protected void updateDirection() {
        
        int roll = (int) (Math.random() * 4);

        if (roll == 0) {

            direction = Direction.North;
        } else if (roll == 1) {

            direction = Direction.East;
        } else if (roll == 2) {

            direction = Direction.West;
        } else if (roll == 3) {

            direction = Direction.South;
        }
    }
}