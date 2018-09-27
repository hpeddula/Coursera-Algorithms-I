
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
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N-1; j++) {
                for (int k = j + 1; k < N-2; k++) {
                    for (int l = k + 1; l < N-3; l++) {
                        if (points[i] == null || points[j] == null || points[k] == null || points[l] == null)
                            throw new java.lang.IllegalArgumentException();
                        if(points[i].compareTo(points[j]) ==0 || points[i].compareTo(points[k]) ==0 || points[i].compareTo(points[l])==0
                            || points[j].compareTo(points[k]) ==0 || points[j].compareTo(points[l])==0 || points[k].compareTo(points[l]) ==0 )
                            throw new java.lang.IllegalArgumentException();
                        p = points[i];
                        q = points[j];
                        r = points[k];
                        s = points[l];
                        pqSlope = p.slopeTo(q);
                        prSlope = p.slopeTo(r);
                        psSlope = p.slopeTo(s);
                        if (pqSlope == prSlope && prSlope == psSlope) {
                            if(p.slopeTo(q) ==0 && p.slopeTo(r) ==0 && p.slopeTo(s) ==0)
                            {lineSegments.add(new LineSegment(p, s));}
                            else
                            {
                                lineSegments.add(new LineSegment(p,q));
                                lineSegments.add(new LineSegment(q,r));
                                lineSegments.add(new LineSegment(r,s));
                            }
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
