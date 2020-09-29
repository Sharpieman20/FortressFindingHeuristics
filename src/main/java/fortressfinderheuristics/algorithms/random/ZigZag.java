package fortressfinderheuristics.algorithms.random;

import fortressfinderheuristics.*;
import fortressfinderheuristics.algorithms.directional.*;
import fortressfinderheuristics.Settings;

import java.lang.Math;
import java.lang.IllegalStateException;

public class ZigZag extends DirectionalAlgorithm {

    protected int ind;
    protected Direction dir1;
    protected Direction dir2;


    public void reset(Position startPos) {

        

        super.reset(startPos);

        int roll = (int) (Math.random() * 4);

        if (roll == 0) {

            dir1 = Direction.North;
        } else if (roll == 1) {

            dir1 = Direction.East;
        } else if (roll == 2) {

            dir1 = Direction.West;
        } else if (roll == 3) {

            dir1 = Direction.South;
        }

        roll = (int) (Math.random() * 2);

        dir2 = dir1.getPerpendicular()[roll];

        // System.out.println("RESET " + dir1 + " " + dir2);

        direction = dir1;
    }

    protected void updateDirection() {

        // System.out.println("update");
        
        if (ind % 2 == 0) {

            direction = dir1;
        } else {

            direction = dir2;
        }

        ind++;
    }
}