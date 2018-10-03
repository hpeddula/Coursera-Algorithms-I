import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item items[];
    private int Last = -1;// this is the indicator for adding items in the beginning of the array.
    private int N = 0;// Count of items.
    private int random;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if(item == null) throw new java.lang.IllegalArgumentException();
        if (Last != -1 &&  Last == items.length-1) resize(2 * items.length);
        items[++Last] = item;
        N++;
//        System.out.println(Arrays.toString(items));
    }

    public Item dequeue() {
        if (N == 0) throw new java.util.NoSuchElementException();
        if (N == items.length/4) resize(items.length / 2);
        random = StdRandom.uniform(0, items.length);
        while (items[random] == null) {
            random = StdRandom.uniform(0, items.length);
        }
        Item item = items[random];
        items[random] = null;
        N--;
//        System.out.println(Arrays.toString(items));
        return item;
    }
    public Item sample()
    {
        if (N == 0) throw new java.util.NoSuchElementException();
        random = StdRandom.uniform(0,items.length);
        while (items[random] == null) {
            random = StdRandom.uniform(0, items.length);
        }
        return items[random];
    }
    private void resize(int capacity)
    {
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
        Last = index -1;
        items = copy;
    }
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item>
    {
//        RandomizedQueue<Item> randomizedQueue = new RandomizedQueue<>();
        Item[] iteratorArray;
        private int i = N;
        public RandomizedQueueIterator()
        {
            iteratorArray = (Item[]) new Object[items.length];
            for (int j = 0; j < iteratorArray.length ; j++) {
                iteratorArray[j] = items[j];
            }
        }
        @Override
        public boolean hasNext() {
            return i>0;
        }
        @Override
        public Item next()
        {
            if(i ==0) throw new java.util.NoSuchElementException();
            else
            {
                random = StdRandom.uniform(0, iteratorArray.length);
                while (iteratorArray[random] == null) {
                    random = StdRandom.uniform(0, iteratorArray.length);
                }
                Item item = iteratorArray[random];
                iteratorArray[random] = null;
//                System.out.println(Arrays.toString(iteratorArray));
                i--;
                return item;
            }
        }
        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
