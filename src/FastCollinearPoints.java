import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints
{
    private int segments=0;
    private Point p;
    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    public FastCollinearPoints(Point[] points)
    {
        if(points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++)
        {
            p=points[i];
            Arrays.sort(points,p.slopeOrder());
            for (int j = 0; j < points.length; j++)
            {

            }
        }
    }
    public int numberOfSegments()
    {
        return segments;
    }
    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
//        for (LineSegment segment : collinear.segments()) {
//            StdOut.println(segment);
//            segment.draw();
//        }
        StdDraw.show();
    }

}
