
package fortressfinderheuristics;

import java.awt.*;
import java.util.Random;

import kaptainwutax.seedutils.mc.MCVersion;

public class Settings {
    public static Random rand = new Random();
    public static World world;

    public static MCVersion version = MCVersion.v1_16_1;

    public static final int SEARCH_DEPTH = 8;
    public static int NUM_WORLDS = 1_000_000;
    public static int NUM_INIT_LOOPS = 5_000_000;

    public static Color hasFortress = Color.RED;
    public static Color noFortress = Color.BLACK;
    public static Color origin = Color.YELLOW;

    public static int X_ABS_MIN = -32;
    public static int Z_ABS_MIN = -32;
    public static int X_ABS_MAX = +33;
    public static int Z_ABS_MAX = +33;

    public static int X_MIN = -32;
    public static int Z_MIN = -32;
    public static int X_MAX = +33;
    public static int Z_MAX = +33;
}