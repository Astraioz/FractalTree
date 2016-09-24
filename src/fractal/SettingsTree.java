package fractal;

public class SettingsTree {

    public static int BRANCH_MIN = 2;
    public static int BRANCH_MAX = 3;
    public static double LENGTH_RATIO_MIN = .6;
    public static double LENGTH_RATIO_MAX = .8;
    public static double STROKE_RATIO_MIN = 0.4;
    public static double STROKE_RATIO_MAX = .9;
    public static double LENGTH_0_MIN = 200;
    public static double LENGTH_0_MAX = 300;
    public static double STROKE_0_MIN = 30;
    public static double STROKE_0_MAX = 50;
    
    public static float EDGE_COLOR_H_MIN = 0.4F;
    public static float EDGE_COLOR_H_MAX = 1F;
    public static float EDGE_COLOR_S = 0.8F;
    public static float EDGE_COLOR_B = 0.7F;
    
    public static int FRAMES_0 = 1000;
    public static int FRAMES(int level) {
        int x = (int) (FRAMES_0 * Math.pow(2, -level));
        return (x == 0 ? 1 : x);
//        return 1000;
    }
    
}
