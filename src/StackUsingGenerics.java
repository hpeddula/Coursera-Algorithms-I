import java.util.Iterator;
public class StackUsingGenerics<Item> implements Iterable<Item>
{
    private Node first;
    private class Node
    {
        Item item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public void push(Item item)
    {
        Node next = first;
        first = new Node();
        first.item = item;
        first.next = next;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
