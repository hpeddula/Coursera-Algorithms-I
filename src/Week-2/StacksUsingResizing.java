public class StacksUsingResizing
{
    int N =0;
    String S[];
    public StacksUsingResizing()
    {
        S= new String[1];
    }
    public boolean isEmpty()
    {
        return N ==0;
    }
    public void push(String item)
    {
        if(N == S.length) resize(2*S.length);
        S[N++] = item;
    }
    public String pop()
    {
        String item = S[--N];
        S[N] = null;
        if(N >0 && N == S.length/4) resize(S.length/2);
        return item;
    }
    public void resize(int capacity)
    {
        String copy[] = new String[capacity];
        for(int i=0;i<N;i++)
        {
            copy[i] = S[i];
        }
        S = copy;
    }
}
