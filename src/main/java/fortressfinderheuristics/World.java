
package fortressfinderheuristics;

import java.util.*;

public class World {

    public long seed;

    public Nether nether;

    public Position spawn;
    
    public World() {

        seed = Settings.rand.nextLong();

        nether = new Nether(this);

        int x = (int) (Math.random() * 2);
        int z = (int) (Math.random() * 2);

        x *= -1;
        z *= -1;

        spawn = Position.get(x,z);
    }

    public Position getSpawn() {

        return spawn;
    }
}