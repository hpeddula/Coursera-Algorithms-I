import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean isOpen[][];
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int width;
    private int count;
    public Percolation(int n)
    {
        if(n <=0)
        {
            throw new IllegalArgumentException();
        }
        else {
            isOpen = new boolean[n][n];
            width = n;
            count =0;
            weightedQuickUnionUF = new WeightedQuickUnionUF((n * n) + 2);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    isOpen[i][j] = false;
                }
            }
        }
    }
    private int getPosition(int row,int col)
    {
        return width * (row - 1)+ col ;
    }
    public void open(int row,int col)
    {
        /**
         * This if condition checks if the site is blocked or open
         * if it is blocked then it opens the site.
         */
        if(!isOpen[row-1][col-1])
        {
            isOpen[row-1][col-1] = true;
            count ++;
            /**
             * This if condition checks if the col is not equal to 1,if it is not 1,
             * then it checks if the site to the left of it is open or not,if open
             * it connects to it's left side.
             */
            if( col != 1 && isOpen[row-1][col-2])
            {
                weightedQuickUnionUF.union(getPosition(row,col-1),getPosition(row,col));
            }
            /**
             * This if condition checks if that the site's column is equal to that of
             * the size of the matrix if it is not equal then it connects to the right
             * site if it's open.
             */
            if(col != width && isOpen[row-1][col])
            {
                weightedQuickUnionUF.union(getPosition(row,col+1),getPosition(row,col));
            }
            /**
             * This if condition checks that if the site's row is not the bottom if yes then it can check if it's bottom
             * site is open or not and connect itself with it.
             */
            if(row != width && isOpen[row][col-1])
            {
                weightedQuickUnionUF.union(getPosition(row+1,col),getPosition(row,col));
            }
            /**
             * This if condition checks if the site's row is not the top row,if it is not the top row then it can check for the
             * openess of the top site and connect to it.
             */
            if(row !=1 && isOpen[row -2][col-1])
            {
                weightedQuickUnionUF.union(getPosition(row-1,col),getPosition(row,col));
            }
            /**
             * This if condition checks that if the site is in the top row then it connects itself to the top virtual site.
             */
            if(row == 1)
            {
                weightedQuickUnionUF.union(getPosition(row  ,col  ),0);
            }
            /**
             * This if condition checks if the site is in the bottom row then it connects itself to the bottom virtual site.
             */
            if(row == width)
            {
                weightedQuickUnionUF.union(getPosition(row  ,col ),(width * width) + 1);
            }
        }
        else return;
    }
    public boolean isOpen(int row,int col)
    {
        return isOpen[row-1][col-1];
    }
    public boolean isFull(int row,int col)
    {
        return weightedQuickUnionUF.connected(getPosition(row,col),0);
    }
    public int numberOfOpenSites()
    {
        return count;
    }
    public boolean percolates()
    {
        return weightedQuickUnionUF.connected(0,(width * width)+1);
    }
}
