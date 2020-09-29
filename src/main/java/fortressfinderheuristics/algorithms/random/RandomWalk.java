package fortressfinderheuristics.algorithms;

import fortressfinderheuristics.Position;
import fortressfinderheuristics.Settings;

import java.lang.Math;
import java.lang.IllegalStateException;

public class RandomWalk extends Algorithm {

    int count1;
    int count2;
    int count3;
    int count4;

    protected void updatePos() {

        int direction = (int) (Math.random() * 4);

        if (direction == 0) {

            count1++;
            curPos.x++;
        } else if (direction == 1) {

            count2++;
            curPos.z++;
        } else if (direction == 2) {

            count3++;
            curPos.x--;
        } else if (direction == 3) {

            count4++;
            curPos.z--;
        } else {

            throw new IllegalStateException();
        }
    }

    public String toString() {

        String count1Str = "count1 " + count1;
        String count2Str = "count2 " + count2;
        String count3Str = "count3 " + count3;
        String count4Str = "count4 " + count4;

        return String.join("\n", count1Str, count2Str, count3Str, count4Str);
    }
}