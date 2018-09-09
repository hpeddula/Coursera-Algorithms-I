import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation_Office {
    private boolean isOpen[][];
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int width ;
    private int count =0;
    public Percolation_Office(int n)
    {
        if(n <=0)
        {
            throw new IllegalArgumentException();
        }
        else {
            width = n;
            weightedQuickUnionUF = new WeightedQuickUnionUF((n * n) + 2);
            isOpen = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    isOpen[i][j] = false;
                }
            }
        }
    }
//    This method is used to get the index of the element in
//    the background 1D array created by the WeightedQuickUnionUF
//    using the row and the col value of the isOpen bool array being provided
//    to the function.

    private int getPosition(int row,int col)
    {
        return width * (row-1) + col;
    }
    public void open(int row,int col)
    {
        if(isOpen[row - 1][col - 1] == false)
        {
            isOpen[row -1][col -1] = true;
            count ++;
        }
        if(col !=1 && isOpen[row-1][col-2])
        {
            weightedQuickUnionUF.union(getPosition(row,col-1),getPosition(row,col));
//            weightedQuickUnionUF.union(getPosition(row-1,col-2),getPosition(row-1,col-1));
        }
        if(col != width && isOpen[row-1][col])
        {
            weightedQuickUnionUF.union(getPosition(row,col+1),getPosition(row,col));
//            weightedQuickUnionUF.union(getPosition(row-1,col),getPosition(row-1,col-1));
        }
        if(row!= 1 && isOpen[row -2][col-1])
        {
            weightedQuickUnionUF.union(getPosition(row-1,col),getPosition(row,col));
//            weightedQuickUnionUF.union(getPosition(row-2,col-1),getPosition(row-1,col-1));
        }
        if(row != width && isOpen[row][col-1])
        {
            weightedQuickUnionUF.union(getPosition(row+1,col),getPosition(row, col));
//            weightedQuickUnionUF.union(getPosition(row,col-1),getPosition(row-1, col-1));
        }
        if(row == 1)
        {
            weightedQuickUnionUF.union(getPosition(row,col),0);
//            weightedQuickUnionUF.union(getPosition(row-1,col-1),0);
        }
        else if(row == width)
        {
            weightedQuickUnionUF.union(getPosition(row,col),(width * width)+1);
//            weightedQuickUnionUF.union(getPosition(row-1,col-1),(width * width)+1);
        }

    }
    public boolean isOpen(int row, int col)
    {
       return isOpen[row-1][col-1];
    }
    public boolean isFull(int row, int col)
    {
        return weightedQuickUnionUF.connected(getPosition(row,col),0);
//        return weightedQuickUnionUF.connected(getPosition(row-1,col-1),(width*width)+1);
    }
    public int numberOfOpenSites()
    {
        return count;
    }
    public boolean percolates()
    {
        return weightedQuickUnionUF.connected(0,(width*width)+1);
    }
}
/**
 * Weighted Quick Union implementation of the QuickFind is the most efficient one of the lot available.
 * Percolation_Office simulates the WeightedQuickUnion Parent 1D array using a 2D array isOpen, the source of truth is
 * the 1D array which is created by the WeightedQuickUnion.The GetPosition Method is used to map to the simulated 1d array of the
 * WeightedQuickUnion.
 */