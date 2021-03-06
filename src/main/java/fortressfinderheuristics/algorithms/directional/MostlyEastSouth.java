package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.*;
import fortressfinderheuristics.algorithms.*;
import fortressfinderheuristics.algorithms.directional.DirectionalAlgorithm;

import java.lang.Math;
import java.lang.IllegalStateException;

public class MostlyEastSouth extends MostlyEast {

    protected void updateDirection() {

        int beforeSteps = stepsRemaining;

        super.updateDirection();

        if (stepsRemaining > beforeSteps) {

            if (direction.equals(Direction.North)) {

                int roll = (int) (Math.random() * 5);

                if (roll != 0) {

                    direction = Direction.South;
                }
            }
        }
    }
}