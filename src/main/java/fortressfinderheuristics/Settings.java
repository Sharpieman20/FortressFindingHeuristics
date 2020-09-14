
package fortressfinderheuristics;

import java.awt.*;
import java.util.Random;

public class Settings {
    public static final int numWorlds = 1000000;
    public static Random rand = new Random();
    public static World world;

    public static int MAX_SEARCH_DIST = 10;

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