import java.util.Iterator;

public class StackUsingArrayGeneric<Item> implements Iterable<Item>
{
    Item s[] = (Item[])new Object[1];
    int N =0;
    public boolean isEmpty()
    {
        return N ==0;
    }
    public void push(Item item)
    {
        s[N++] = item;
    }
    public Item pop()
    {
        Item item = s[--N];
        s[N] = null;
        return item;
    }
    public void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for(int i =0;i<N;i++)
        {
            copy[i] = s[i];
        }
        s= copy;
    }
    public Iterator<Item> iterator()
    {
        return new ReverseIterator();
    }
    private class ReverseIterator implements Iterator<Item>
    {
        private int i =N;
        public boolean hasNext() {return i>0;}
        public Item next()
        {
            return s[--i];
        }

    }
}
