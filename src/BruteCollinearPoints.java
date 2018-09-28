
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;

public class BruteCollinearPoints {
    private int  N;
    private double pqSlope, prSlope, psSlope;
    private Point p, q, r, s;
    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    private LineSegment[] lineSegments1;

    public BruteCollinearPoints(Point[] points) {
        N = points.length;
        if (points == null) throw new java.lang.IllegalArgumentException();
        for (Point p:points
             ) {
            if(p == null) throw new java.lang.IllegalArgumentException();
        }
        for (int i = 0; i <N ; i++) {
            for (int j = 1; j <N ; j++) {
                if(points[i].compareTo(points[j]) ==0) throw new java.lang.IllegalArgumentException();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N-1; j++) {
                for (int k = j + 1; k < N-2; k++) {
                    for (int l = k + 1; l < N-3; l++) {
                        p = points[i];
                        q = points[j];
                        r = points[k];
                        s = points[l];
                        pqSlope = p.slopeTo(q);
                        prSlope = p.slopeTo(r);
                        psSlope = p.slopeTo(s);
                        if (pqSlope == prSlope && prSlope == psSlope) {
                            {lineSegments.add(new LineSegment(p, s));}
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return lineSegments1.length;
    }

    public LineSegment[] segments() {
        lineSegments1 = new LineSegment[lineSegments.size()];
        lineSegments1 = lineSegments.toArray(lineSegments1);
        return lineSegments1;
    }
}
