import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    Item items[];
    private int First =-1;// this is the indicator for adding items in the beginning of the array.
    int N =0;// Count of items.
    int random;
    public RandomizedQueue()
    {
        items = (Item[]) new Object[1];
    }
    public boolean isEmpty()
    {
        return N ==0;
    }
    public int size()
    {
        return N;
    }
    public void enqueue(Item item)
    {
        if(N==0) First = -1;
        if(First != -1 && N == items.length) resize(2*items.length);
        items[++First]= item;
        N++;
    }
    public Item dequeue()
    {
        if(N ==0) First =-1;
        if(N == items.length/4) resize(items.length/2);
        random = StdRandom.uniform(0,items.length);
        while(items[random] ==null)
        {
            random = StdRandom.uniform(0,items.length);
        }
        Item item = items[random];
        items[random] = null;
        N--;
        return item;
    }
    public Item sample()
    {
        random = StdRandom.uniform(0,items.length);
        return items[random];
    }
    private void resize(int capacity)
    {
        int notNull=0;
        for (int i = 0; i <items.length ; i++) {
            if(items[i]!= null)
            {
                notNull++;
            }
        }
        Item[] notNullElements = (Item[]) new Object[items.length];
        int index =0;
        for (int i = 0; i <items.length; i++) {
            if(items[i]!= null)
            {
                notNullElements[index++] = items[i];
            }
        }
        Item copy[] = (Item[]) new Object[capacity];
        for(int i=0;i<N;i++)
        {
            copy[i] =  notNullElements[i];
        }
        items = copy;
    }
    @Override
    public Iterator<Item> iterator() {
        return null;
    }
    private class RandomizedQueueIterator implements Iterator<Item>
    {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }
}