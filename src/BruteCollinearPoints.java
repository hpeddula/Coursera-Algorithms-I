import java.util.ArrayList;

public class BruteCollinearPoints
{
    private int segments=0;
    private double pqSlope,prSlope,psSlope;
    private Point p,q,r,s;
    private ArrayList<LineSegment> lineSegments = new ArrayList<>();
    public BruteCollinearPoints(Point[] points)
    {
        int N = points.length;
        if(points == null) throw new java.lang.IllegalArgumentException();
        for (int i = 0; i < N ; i++)
        {
            for (int j = i+1; j < N; j++)
            {
                for (int k = j+1; k < N ; k++)
                {
                    for (int l = k+1; l <N ; l++)
                    {
                        if(points[i] == null || points[j] == null || points[k] == null || points[l] == null) throw new java.lang.IllegalArgumentException();
                        if(points[i].equals(points[j]) || points[i].equals(points[k]) || points[i].equals(l) || points[j].equals(points[k]) || points[j].equals(l) || points[k].equals(l)) throw new java.lang.IllegalArgumentException();
                        p = points[i];
                        q = points[j];
                        r = points[k];
                        s = points[l];
                        pqSlope = p.slopeTo(q);
                        prSlope = p.slopeTo(r);
                        psSlope = p.slopeTo(s);
                        if(pqSlope == prSlope && prSlope == psSlope)
                        {
                            segments +=1;
                            lineSegments.add(new LineSegment(p,s));
                        }
                    }
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
        return lineSegments1 ;
    }
}
