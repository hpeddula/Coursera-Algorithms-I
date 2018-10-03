package StacksandQueues;

public class QueueUsingLinkedList_Office {
    private Node first, last;
    private class Node
    {
        String item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public void push(String item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }
    public String pop()
    {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
    }
}
