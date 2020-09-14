
package fortressfinderheuristics;

import java.util.*;

public class World {

    public long seed;

    public Nether nether;

    public Position spawn;
    
    public World() {

        seed = Settings.rand.nextLong();

        nether = new Nether();

        int x = (int) (-1*(Math.abs(Settings.rand.nextLong()) % 2));
        int z = (int) (-1*(Math.abs(Settings.rand.nextLong()) % 2));

        spawn = new Position(x,z);
    }

    public Position getSpawn() {

        return spawn;
    }
}