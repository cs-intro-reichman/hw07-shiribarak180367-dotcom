
/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

    public static void main(String[] args) {
        sierpinski(Integer.parseInt(args[0]));
    }

    // Draws a Sierpinski triangle of depth n on the standard canvass.
    public static void sierpinski(int n) {

        double[] xVertex = {0.0, 1.0, 0.5};
        double[] yVertex = {0.0, 0.0, 0.866};
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);
        StdDraw.enableDoubleBuffering();
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(xVertex[0], yVertex[0], xVertex[1], yVertex[1]);
        StdDraw.line(xVertex[1], yVertex[1], xVertex[2], yVertex[2]);
        StdDraw.line(xVertex[0], yVertex[0], xVertex[2], yVertex[2]);

        sierpinski(n,
                xVertex[0], xVertex[1], xVertex[2],
                yVertex[0], yVertex[1], yVertex[2]);
        StdDraw.show();

    }

    // Does the actual drawing, recursively.
    private static void sierpinski(int n, double x1, double x2, double x3,
            double y1, double y2, double y3) {
        if (n == 0) {
            return;
        }
        double midX1 = (x1 + x2) / 2;
        double midY1 = (y1 + y2) / 2;
        double midX2 = (x2 + x3) / 2;
        double midY2 = (y2 + y3) / 2;
        double midX3 = (x1 + x3) / 2;
        double midY3 = (y1 + y3) / 2;
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(midX1, midY1, midX2, midY2);
        StdDraw.line(midX2, midY2, midX3, midY3);
        StdDraw.line(midX3, midY3, midX1, midY1);
        StdDraw.setPenColor(StdDraw.BLACK);
        sierpinski(n - 1, x1, midX1, midX3, y1, midY1, midY3);
        sierpinski(n - 1, midX1, x2, midX2, midY1, y2, midY2);
        sierpinski(n - 1, midX3, midX2, x3, midY3, midY2, y3);

    }
}
