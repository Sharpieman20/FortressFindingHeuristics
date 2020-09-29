package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.*;
import fortressfinderheuristics.algorithms.*;
import fortressfinderheuristics.algorithms.directional.DirectionalAlgorithm;

import java.lang.Math;
import java.lang.IllegalStateException;

public class MostlyEast extends DirectionalAlgorithm {

    protected int stepsRemaining = 0;

    public MostlyEast() {

        direction = Direction.East;
    }

    protected void updateDirection() {

        if (stepsRemaining > 0) {

            stepsRemaining--;
        } else {

            int roll = (int) (Math.random() * 5);

            if (roll == 0) {

                // Impassable terrain, we must change directions

                int changeTo = (int) (Math.random() * 2);

                direction = direction.getPerpendicular()[changeTo];

                stepsRemaining = (int) (Math.random() * 3);
            } else {

                direction = Direction.East;
            }
        }


    }
}