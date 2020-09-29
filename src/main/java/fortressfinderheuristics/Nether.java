
package fortressfinderheuristics;

import kaptainwutax.featureutils.structure.Fortress;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.mc.pos.CPos;

import fortressfinderheuristics.*;

import java.util.Random;
import java.awt.*;
import java.util.*;
import java.util.Collections;

public class Nether {

    private World world;
    private Fortress f = new Fortress(Settings.version);

    boolean[][] fortressLocs; 
    PositionInfoStore posConverter;

    public Nether(World world) {

        this.world = world;

        posConverter = new PositionInfoStore(-Settings.SEARCH_DEPTH);

        searchAroundOrigin();
    }

    public boolean hasFortressInRegion(int x, int z) {

        int i = posConverter.convertXToIndex(x);
        int j = posConverter.convertZToIndex(z);

        if (i == 19 || i < 0 || j == 19 || j < 0) {
            // System.out.println("x: " + x + " z: " + z + "\ni: " + i + " j: " + j);
        }

        return fortressLocs[i][j];
    }

    public boolean hasFortressInRegion(Position pos) {

        return hasFortressInRegion(pos.x, pos.z);
    }

    private boolean hasFortressInRegionInner(int x, int z) {
        CPos isInRegion;

        isInRegion = f.getInRegion(world.seed, x, z, new ChunkRand());

        return isInRegion == null;
    }

    public void searchAroundOrigin() {

        fortressLocs = new boolean[posConverter.getSize()][posConverter.getSize()];

        for (Position pos : posConverter.exploreAll()) {

            int i = posConverter.convertXToIndex(pos.x);
            int j = posConverter.convertZToIndex(pos.z);

            // System.out.println(i + " " + j);

            fortressLocs[i][j] = hasFortressInRegionInner(pos.x, pos.z);
        }
    }
}