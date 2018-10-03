package Sorts;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints
{
    private int segments=0,N;
    private Point p;
    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    public FastCollinearPoints(Point[] points)
    {
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
        for (int i = 0; i < points.length; i++)
        {
            p=points[i];
            Arrays.sort(points,p.slopeOrder());
            for (int j = 0; j < points.length; j++)
            {
                while(j+2 < points.length)
                {
                    Double pq1Slope = p.slopeTo(points[j]);
                    Double pq2Slope = p.slopeTo(points[j+1]);
                    Double pq3Slope = p.slopeTo(points[j+2]);
                    if(pq1Slope.equals(pq2Slope) && pq2Slope.equals(pq3Slope) )
                    {
                        segments +=1;
                        lineSegments.add(new LineSegment(p,points[j+2]));
                    }
                    j +=1;
                }
            }
        }
    }
    public int numberOfSegments()
    {
        return segments;
    }
    public LineSegment[] segments()
    {
        LineSegment[] lineSegments1 = new LineSegment[lineSegments.size()];
        lineSegments1 = lineSegments.toArray(lineSegments1);
        return lineSegments1;
    }
}
