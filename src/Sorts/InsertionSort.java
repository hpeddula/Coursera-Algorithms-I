package Sorts;

public class InsertionSort
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = i; j >0 ; j--)
            {
                if(less(a[j],a[j-1]))
                    exch(a,j,j-1);
            }
        }
    }
    public static boolean less(Comparable v,Comparable w)
    {
        int res = v.compareTo(w);
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a,int i,int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    public static void main(String[] args)
    {
        String s[] = new String[]{"S","O","R","T","E","X","A","M","P","L","E"};
        InsertionSort.sort(s);
    }
}

