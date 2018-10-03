package StacksandQueues;

public class StackUsingNode
{
    private Node first = null;
    private class Node
    {
        String item;
        Node next;
    }
    public boolean isEmpty(Node first)
    {
        return first.next == null;

    }
    public void push(String item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }
}
/**
 * This is the implementation of stack using the linked list,linked list here in this code is denoted by a private class
 * Node which has two props item which for now is a string and refers to the data and the next property is next which itself
 * represents the next node in the linked list. Stack is LIFO so the last element inserted get's popped out first.
 * For a stack the insertion and deletion takes place from the front so we maintain only one pointer.
 */
/** Inserting into Stack using Linked List
 * When inserting a new node in the linked list we must first store the information of the node pointed by the pointer first in a reference of type Node oldfirst in this
 * example then push the new item into the item prop of the first node and assign the next property of the first pointer to point to the oldfirst
 * next property,this makes the first pointer to point to the newly inserted item and the previous node being pointed by the first pointer
 * becomes the second node in the linked list.
 *
 */
/** Removing from Stack Linked List implementation
 * When removing an item from stack the removal also happens from the front as the data structure being implemented is stack
 * whe removing an item we need to make the pointer to point to the next node in the linked list, this is achieved by making the
 * first to point to the next node in the linked list,by doing this the previous node is made available to the garbage collector.
 */