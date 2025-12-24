
/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        //// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.
       StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0, 1.1);
        StdDraw.setYscale(0, 1.1);
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.enableDoubleBuffering();

        // Tests the curve function:
        //Gets n, x1, y1, x2, y2,
        //and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
        //curve(Integer.parseInt(args[0]),
        //Double.parseDouble(args[1]), Double.parseDouble(args[2]),
        //  Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        // StdDraw.show();
        // Tests the snowflake function:
        // Gets n, and draws a Koch snowflake of n edges in the standard canvass.
        snowFlake(Integer.parseInt(args[0]));
    }

    /**
     * Gets n, x1, y1, x2, y2, and draws a Koch curve of depth n from (x1,y1) to
     * (x2,y2).
     */
    public static void curve(int n, double x1, double y1, double x2, double y2) {

        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        double ax = x1 + (x2 - x1) / 3.0;
        double ay = y1 + (y2 - y1) / 3.0;

        double bx = x1 + 2.0 * (x2 - x1) / 3.0;
        double by = y1 + 2.0 * (y2 - y1) / 3.0;

        double cx = (Math.sqrt(3) / 6.0) * (ay - by) + (ax + bx) / 2.0;
        double cy = (Math.sqrt(3) / 6.0) * (bx - ax) + (ay + by) / 2.0;

        curve(n - 1, x1, y1, ax, ay);
        curve(n - 1, ax, ay, cx, cy);
        curve(n - 1, cx, cy, bx, by);
        curve(n - 1, bx, by, x2, y2);
    }

    /**
     * Gets n, and draws a Koch snowflake of n edges in the standard canvass.
     */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        double x1 = 0.1, y1 = 0.1;
        double x2 = 1.0, y2 = 0.1;
        double x3 = 0.55, y3 = 0.9;
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
        StdDraw.show();

    }
}
