import java.util.Iterator;

public class DequeLinkedList<Item> implements Iterable<Item>
{
    private Node First,Last,OldLast;
    private int N=0; // Count of Nodes
    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }
    public DequeLinkedList()
    {
         First = new Node();
         Last = new Node();
        OldLast = new Node();
    }
    public boolean isEmpty()
    {
        return First.item == null && Last.item == null;
    }
    public int size()
    {
        return N;
    }
    public void addFirst(Item item)
    {
        if(isEmpty())
        {
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
        if(isEmpty())
        {
            Last.item = item;
            Last.next = null;
            Last.previous = null;
            First = Last;
            N++;
        }
        else
        {
            Node oldFirst;
            if(First != null)
            {
                oldFirst = Last;
            }
            else
            {
                oldFirst = First;
            }
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
        Item item = First.item;
        First = First.next;
        First.next.previous =null;
        N--;
        return item;
    }
    public Item removeLast()
    {
        Item item = Last.item;
        Last.previous.next = null;
        Last =Last.previous ;
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
        public boolean hasNext()
        {
            return current.next !=null;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
