import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats
{
    private double threshold[];
    private int T ;
    public PercolationStats(int n,int trials)
    {
        if(n <=0 || trials <=0)
        {
            throw new IllegalArgumentException();
        }
        threshold = new double[trials];
        T = trials;
        for(int i=0;i<trials;i++)
        {
            Percolation percolation = new Percolation(n);
            while(!percolation.percolates())
            {
                int a = StdRandom.uniform(1,n+1);
                int b = StdRandom.uniform(1,n+1);
                percolation.open(a, b);
            }
            threshold[i] = percolation.numberOfOpenSites()/(double)(n*n);
        }
    }
    public double mean()
    {
        return StdStats.mean(threshold);

    }
    public double stddev()
    {
        return StdStats.stddev(threshold);
    }
    public double confidenceLo()
    {
        return StdStats.mean(threshold) - 1.96/Math.sqrt(T);
    }
    public double confidenceHi()
    {
        return StdStats.mean(threshold) +1.96/Math.sqrt(T);
    }
    public static void main(String[] args)
    {

    }
}
