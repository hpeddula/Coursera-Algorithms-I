package StacksandQueues;

public class StackUsingResizing
{
    int N =0;
    String[] S = new String[1];

    public void push(String item)
    {
        if(N == S.length) resize(2* S.length);
        S[N++] = item;

    }
    public boolean isEmpty()
    {
        return N ==0;
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
        String[] copy = new String[capacity];
        for (int i=0; i< N;i++)
            copy[i] = S[i];
        S = copy;
    }
}
/** Implementing Stack using an array,which is considered a better implementation than linked list
 * When stack is implemented using an array it is done using the concept of Reszizing array as it an incedious bug to
 * initialize an array with a fixed size and the array must have the dynamic ability of resizing itself with respect to the
 * elements being inserted.To start of we intialize the array to be of length 1 and in the push and the pop methods we resize the array.
 */
/** The Resize Method
 * The resize method takes in a parameter capacity to initialise a temporary array copy into which all the
 * existing elements of the original array will be copied into and then reassign the temporary array to the original array,which
 * inturn increases the size of the original array and also helps it retain it's original members.
 */
/** Push Operation
 * As the stack is being implemented using an array,there is no need of maintaining a separate pointer the array index itself acts
 * as a pointer, the array S is indexed using the value of N and the item is stored at that index and then the index value is
 * incremented.
 * Prior to performing this a check is always made that decides if the array has to be resized or not.
 * If N is equal to length of the array then resize it to twice the current length of the array.
 */
/** Pop Operation
 * In the Pop operation the element at the end of the array is removed as the latest element in the array implementation of the stack
 * get's inserted at the last so we remove the last element and fill in that index with null and check if the quarter of the array is full
 * if the check fails then it means that more than quarter is full and no need to resize,if it is equal to quarter then the array size
 * has to be reduced to half it's size so this provides us with the invariant that the array is always between 25% and 100% full.
 */