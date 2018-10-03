package StacksandQueues;

public class StackUsingArray
{
    private String S[];
    private int N =0;
    public StackUsingArray(int capacity)
    {
        S = new String[capacity];
    }
    public boolean isEmpty()
    {
        return N ==0;
    }
    public void push(String item)
    {
        S[N++] = item;
    }
    public String pop()
    {
        String item = S[--N];
        S[N] = null;
        return item;
    }
}
