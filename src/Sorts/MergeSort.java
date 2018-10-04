package Sorts;

public class MergeSort
{
    private static void merge(Comparable[] a,Comparable[] aux,int lo,int mid,int hi)
    {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i =lo,j = mid+1;
        for (int k = lo; k <=hi ; k++)
        {
            if(i>mid) a[k]=aux[j++];
            if(j > hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else a[k]=aux[i++];
        }
    }
    public static void sort(Comparable[] a,Comparable[] aux,int lo,int hi)
    {
        if(hi <= lo) return;
        int mid = lo + (hi - lo) /2;
        sort(a,aux,lo,mid); // Sorts the lower half.
        sort(a,aux,mid+1,hi); // Sorts the upper half.
        merge(a,aux,lo,mid,hi);
    }
    public static void sort(Comparable[] a)
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);

    }
    public static boolean less(Comparable v,Comparable w)
    {
        int res = v.compareTo(w);
        return v.compareTo(w) < 0;
    }
    public static void exch(Comparable[] a,int i,int j)
    {
        Comparable swap = a[i];
        a[j] = swap;
        a[j] = swap;
    }
    public static void main(String[] args)
    {
        String[] arr = new String[]{"M","E","R","G","E","S","O","R","T","E","X","A","M","P","L","E"};
        MergeSort.sort(arr);
    }
}
