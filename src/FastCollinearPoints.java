import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class FastCollinearPoints
{
    private int segments=0,N;
    private Point p,q;
    private double pqSlope=0;
    Double[] slopes;
    public FastCollinearPoints(Point[] points)
    {
        N = points.length;
        slopes = new Double[N];
        if(points == null) throw new IllegalArgumentException();
        for (int i = 0; i <N ; i++)
        {
            p=points[i];
            for (int j = i+1; j <N ; j++)
            {
                q=points[j];
                pqSlope = p.slopeTo(q);
                slopes[j-1] = pqSlope;
                
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
