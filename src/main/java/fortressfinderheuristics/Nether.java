
package fortressfinderheuristics;

import kaptainwutax.featureutils.structure.Fortress;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.mc.pos.CPos;

import java.util.Random;
import java.awt.*;

public class Nether {

    private Fortress f = new Fortress(MCVersion.v1_8);

    public boolean checkIfInRegion(Position pos) {
        CPos isInRegion;

        int x = pos.x;
        int z = pos.z;

        isInRegion = f.getInRegion(Settings.world.seed,x,z, new ChunkRand());

        Color toSet = null;


        if (x == 0 && z == -1) {
            toSet = Settings.origin;

            // if (isInRegion != null) {
            //     System.out.println(isInRegion.toBlockPos());
            // }
        } else if (x >= -1 && x <= 0 && z >= -1 && z <= 1) {

        }
        if (toSet == null) {
            if (isInRegion != null) {

                toSet = Settings.hasFortress;
            } else {

                toSet = Settings.noFortress;
            }

        }


        // GridView.setGridColor(z - Settings.Z_ABS_MIN, x - Settings.X_ABS_MIN, toSet);

        return isInRegion == null;
    }

    public boolean[][] searchAroundOrigin() {

        boolean[][] locs = new boolean[Settings.X_MAX - Settings.X_MIN][Settings.Z_MAX - Settings.Z_MIN];

        for(int i = Settings.X_MIN; i < Settings.X_MAX; i++) {

            for (int j = Settings.Z_MIN; j < Settings.Z_MAX; j++) {

                locs[i - Settings.X_MIN][j - Settings.Z_MIN] = checkIfInRegion(new Position(i, j));
            }
        }
        
        return locs;
    }
}