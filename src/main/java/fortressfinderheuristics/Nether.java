
package fortressfinderheuristics;

import kaptainwutax.featureutils.structure.Fortress;
import kaptainwutax.featureutils.structure.BastionRemnant;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.mc.pos.CPos;

import fortressfinderheuristics.*;

import java.util.Random;
import java.awt.*;
import java.util.*;
import java.util.Collections;

public class Nether {

    public enum Structure {

        Fortress,
        Bastion
    }

    private World world;
    private Fortress f = new Fortress(Settings.version);
    private BastionRemnant b = new BastionRemnant(Settings.version);

    boolean[][] fortressLocs;
    boolean[][] bastionLocs;
    PositionInfoStore posConverter;

    public Nether(World world) {

        this.world = world;

        posConverter = new PositionInfoStore(-Settings.SEARCH_DEPTH);

        searchAroundOrigin();
    }

    public boolean hasStructureInRegion(int x, int z) {

        if (Settings.STRUCTURE == Nether.Structure.Fortress) {

            return hasFortressInRegion(x, z);
        } else if (Settings.STRUCTURE == Nether.Structure.Bastion) {

            return hasBastionInRegion(x, z);
        }

        return false;
    }

    public boolean hasBastionInRegion(int x, int z) {

        int i = posConverter.convertXToIndex(x);
        int j = posConverter.convertZToIndex(z);

        return bastionLocs[i][j];
    }

    public boolean hasFortressInRegion(int x, int z) {

        int i = posConverter.convertXToIndex(x);
        int j = posConverter.convertZToIndex(z);

        if (i == 19 || i < 0 || j == 19 || j < 0) {
            // System.out.println("x: " + x + " z: " + z + "\ni: " + i + " j: " + j);
        }

        return fortressLocs[i][j];
    }

    public boolean hasStructureInRegion(Position pos) {

        return hasStructureInRegion(pos.x, pos.z);
    }

    private boolean hasFortressInRegionInner(int x, int z) {
        CPos isInRegion;

        isInRegion = f.getInRegion(world.seed, x, z, new ChunkRand());

        // if (f.canStart())

        return isInRegion != null;
    }

    private boolean hasBastionInRegionInner(int x, int z) {

        CPos isInRegion;

        isInRegion = b.getInRegion(world.seed, x, z, new ChunkRand());

        return isInRegion != null;
    }

    public void searchAroundOrigin() {

        bastionLocs = new boolean[posConverter.getSize()][posConverter.getSize()];
        fortressLocs = new boolean[posConverter.getSize()][posConverter.getSize()];

        for (Position pos : posConverter.exploreAll()) {

            int i = posConverter.convertXToIndex(pos.x);
            int j = posConverter.convertZToIndex(pos.z);

            // System.out.println(i + " " + j);

            fortressLocs[i][j] = hasFortressInRegionInner(pos.x, pos.z);
            bastionLocs[i][j] = hasBastionInRegionInner(pos.x, pos.z);
        }
    }
}