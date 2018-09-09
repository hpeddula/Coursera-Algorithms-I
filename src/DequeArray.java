import java.util.Iterator;

public class DequeArray<Item> implements Iterable<Item>
{
    private Item[] deque;
    private int N = 0;
    private int front = -1;
    private int end =0 ;
    public DequeArray()
    {
        deque = (Item[]) new Object[1];

    }
    public boolean isEmpty()
    {
        return N ==0;
    }
    public int size()
    {
        return N;
    }
    public void addFirst(Item item)
    {
        Item firstTemp;
        if(N == deque.length) resize(2*deque.length,front,end);
        if(isEmpty()) {
            deque[++front] = item;
            end = front;
            N++;
        }
        else
        {
            firstTemp =deque[0] ;
//            front =0;
            deque[0] = item;
            deque[++front]= firstTemp;
            N++;
        }
    }
    public void addLast(Item item)
    {
        Item lastTemp;
        if(N == deque.length) resize(2*deque.length,front,end);
        if(isEmpty())
        {
            deque[end]=item;
            front = end;
            N++;
        }
        else
        {
            deque[end]=item;
            N++;
        }
    }
    public Item removeFirst()
    {
        Item item = deque[front];
        deque[front] = null;
        N--;
        if(N==0)
        {
            front =-1;
            end =-1;
        }
        else
        {
            front++;
            if(N== deque.length/4) resize(deque.length/2,front,end);
        }
        return item;
    }
    public Item removeLast()
    {
        return null;
    }
    public Iterator<Item> iterator()
    {
        return new  DequeIterator();
    }
    private void resize(int capacity,int first,int last)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = deque[i];
        }
//        front =first;
        end =N;
        deque = copy;
    }
    private class DequeIterator implements Iterator<Item>
    {
        private int i = end;

        @Override
        public boolean hasNext() {
            return i>0;
        }
        public Item next()
        {
            return deque[--i];
        }
    }
}
