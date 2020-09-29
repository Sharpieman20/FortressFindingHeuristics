package fortressfinderheuristics.algorithms.directional;

import fortressfinderheuristics.*;
import fortressfinderheuristics.algorithms.random.*;
import fortressfinderheuristics.algorithms.directional.*;
import fortressfinderheuristics.Settings;

import java.lang.Math;
import java.lang.IllegalStateException;
import java.util.*;
import java.util.Collections;
import java.awt.*;

public class MostlyZigZag extends ZigZag {

    protected void updateDirection() {

        super.updateDirection();

        int roll = (int) (Math.random() * 5);

        if (roll == 0) {
            // Direction we want to go is impassable

            if (dir1.equals(direction)) {

                this.direction = dir2;
            } else {

                this.direction = dir1;
            }

            roll = (int) (Math.random() * 5);

            if (roll == 0) {

                // Both are impassable
                
                ArrayList<Direction> options = new ArrayList<Direction>();

                options.add(Direction.North);
                options.add(Direction.East);
                options.add(Direction.South);
                options.add(Direction.West);

                for (int i = 0; i < 4; i++) {
                    if (i < options.size()) {

                        Direction dir = options.get(i);

                        if (dir1.equals(dir) || dir2.equals(dir)) {
                            options.remove(dir);
                            i--;
                        }
                    }
                }

                roll = (int) (Math.random() * 2);

                // System.out.println(options);

                this.direction = options.get(roll);
            }
        }

        // roll = (int) (Math.random() * 5);
        // if (roll == 0) {
        //     ind--;
        // }
    }
}