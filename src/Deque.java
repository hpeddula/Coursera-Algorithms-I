import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>
{
    private Node First,Last,OldLast = null;
    private int N=0; // Count of Nodes
    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }
    public Deque()
    {

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

        if(item == null) throw new IllegalArgumentException();
        if(isEmpty())
        {
            First = new Node();
            First.item = item;
            First.next = null;
            First.previous = null;
            Last = First;
            N++;
        }
        else
        {
            Node oldFirst = First;
            First = new Node();
            First.item = item;
            if(oldFirst.next == null)
            {
                oldFirst.next = null;
            }
            oldFirst.previous = First;
            First.previous = null;
            First.next=oldFirst;
            N++;
        }
    }
    public void addLast(Item item)
    {
        if(item == null) throw new IllegalArgumentException();
        if(isEmpty())
        {
            Last = new Node();
            Last.item = item;
            Last.next = null;
            Last.previous = null;
            First = Last;
            N++;
        }
        else
        {
            Node oldFirst = First;
            while(oldFirst.next != null)
            {
                oldFirst = oldFirst.next;

            }
            OldLast = oldFirst;
            Last = new Node();
            Last.item = item;
            Last.next = null;
            Last.previous = OldLast;
            OldLast.next = Last;
            N++;
        }
    }
    public Item removeFirst()
    {
        if(N==0) throw new java.util.NoSuchElementException();
        Item item = First.item;
        if(First.next != null) First = First.next;
        if (First.next != null) First.next.previous = null;
        N--;
        return item;
    }
    public Item removeLast()
    {
        if(N==0) throw new java.util.NoSuchElementException();
        Item item = Last.item;
        if (Last.previous != null)Last.previous.next = null;
        if (Last.previous != null)Last =Last.previous ;
        N--;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item>
    {
        Node current = First;
        @Override
        public boolean hasNext()
        {
            return current!= null;
        }

        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
        @Override
        public Item next()
        {
            if(current == null) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
