package StacksandQueues;

public class QueueUsingLinkedList
{
    private Node first,last;
    private class Node
    {
        String item;
        Node next;
    }
    public boolean isEmpty()
    {
        return first == null;
    }
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
    }
    public String dequeue()
    {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return  item;
    }
}
/** Queue is a data structure where the removal of the items take place from the beginning and the insertion happens from
 * the back.
 */
/**
 * Enqueue for Queue
 * We create a new variable oldLast of type node and it is assigned the value of the current last node in the linked list.
 * We then re-initialize the last instance variable declared in the beginning and assign the item prop to the item passed
 * into the method and make the next to null,we then check if the queue is empty or not if it is empty then the re-initialized
 * last is assigned to the first as it will be the only node, if not then the oldLast which was assigned the current last is made
 * to the new last.
 */
/** Dequeue for Queue
 * For a queue the removal of the item takes from the front
 * So it is similar to pop of stack we store the item in a temporary item and then make first point to the next node and then check
 * if the queue is empty if it is then last is made null and return the item.
 */