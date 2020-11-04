
package fortressfinderheuristics;

import fortressfinderheuristics.algorithms.*;
import fortressfinderheuristics.algorithms.simple.*;
import fortressfinderheuristics.algorithms.directional.*;
import fortressfinderheuristics.algorithms.random.*;
import fortressfinderheuristics.database.PositionDatabase;

import kaptainwutax.featureutils.structure.Fortress;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.mc.pos.CPos;

import java.util.*;
import java.util.Collections;
import java.awt.*;


public class App {
    public static void main(String[] args) {

        Algorithm mine = new West();

        if (mine.usesPositionDatabase()) {

            PositionDatabase.initialize();

            System.out.println("Initialization complete!");
        }

        

        ArrayList<Double> scores = new ArrayList<Double>();

        double total = 0;
        int max = 0;

        for (int i = 0; i < Settings.NUM_WORLDS; i++) {

            // System.out.println(i);

            Settings.world = new World();

            mine.reset(Settings.world.spawn);

            double score = Tester.scoreAlgorithm(mine);

            if (score == 16.0) {

                max++;
            }

            total += score;

            // System.out.println(total);

            scores.add(score);
        }

        System.out.println(scores.size());

        Collections.sort(scores);

        double firstPercentile = scores.get(Settings.NUM_WORLDS / 100);

        double tenthPercentile = scores.get(Settings.NUM_WORLDS / 10);

        double thirtiethPercentile = scores.get(Settings.NUM_WORLDS / 3);

        System.out.println(String.format("%.2f",100*((double)max) / Settings.NUM_WORLDS)+"%");
        System.out.println(total);

        double avg = total / Settings.NUM_WORLDS;

        // System.out.println("1st Percentile: " + firstPercentile);
        // System.out.println("10th Percentile: " + tenthPercentile);
        // System.out.println("33rd Percentile: " + thirtiethPercentile);
        System.out.println(scores.get(scores.size()-1));
        System.out.println(mine);
        System.out.println("Avg: " + avg);
    }
}
