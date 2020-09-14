
package fortressfinderheuristics;

import fortressfinderheuristics.algorithms.*;

import kaptainwutax.featureutils.structure.Fortress;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.mc.pos.CPos;

import java.util.*;
import java.util.Collections;
import java.awt.*;


public class App {


    public static void main(String[] args) {
        
        Algorithm mine = new NorthSouth();

        ArrayList<Double> scores = new ArrayList<Double>();

        double total = 0;

        for (int i = 0; i < Settings.numWorlds; i++) {

            Settings.world = new World();

            double score = Tester.scoreAlgorithm(mine);

            total += score;

            // System.out.println(score);

            scores.add(score);
        }

        Collections.sort(scores);

        double firstPercentile = scores.get(Settings.numWorlds / 100);

        double tenthPercentile = scores.get(Settings.numWorlds / 10);

        double thirtiethPercentile = scores.get(Settings.numWorlds / 3);

        double avg = total / Settings.numWorlds;

        System.out.println("1st Percentile: " + firstPercentile);
        System.out.println("10th Percentile: " + tenthPercentile);
        System.out.println("33rd Percentile: " + thirtiethPercentile);
        System.out.println("Avg: " + avg);
    }
}
