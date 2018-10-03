package UnionFind;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats_Office
{
    double[] threshold;
    int T;
    public PercolationStats_Office(int n, int trials)
    {
        if(n<=0 || trials <=0)
        {
            throw new IllegalArgumentException();
        }
        else {
            threshold = new double[trials];
            T = trials;
            for (int i = 0; i < trials; i++)
            {
                Percolation_Office percolation = new Percolation_Office(n);
                while (!percolation.percolates())
                {
                    percolation.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));
                }
                threshold[i] = percolation.numberOfOpenSites()/(double)(n*n);
            }
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
        return StdStats.mean(threshold) + 1.96/Math.sqrt(T);
    }
    public static void main(String[] args)
    {

    }
}
