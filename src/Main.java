import StacksandQueues.Deque;

public class Main {

    public static void main(String[] args)
    {
	// write your code here
//        StacksandQueues.RandomizedQueue<String> randomizedQueue = new StacksandQueues.RandomizedQueue<>();
//        randomizedQueue.enqueue("to");
//        randomizedQueue.enqueue("be");
//        randomizedQueue.enqueue("or");
//        randomizedQueue.enqueue("not");
//        randomizedQueue.enqueue("h1");
//        randomizedQueue.enqueue("h2");
//        randomizedQueue.enqueue("h3");
//        randomizedQueue.enqueue("h4");
//        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
////        randomizedQueue.dequeue();
////        randomizedQueue.dequeue();
////        randomizedQueue.dequeue();
////        randomizedQueue.dequeue();
//        randomizedQueue.enqueue("h5");
//        randomizedQueue.enqueue("h6");
//        randomizedQueue.enqueue("h7");
//        randomizedQueue.enqueue("h8");
//        System.out.println("-------------First Iterator-----------");
//        for (String r:randomizedQueue)
//        {
//            System.out.println(r);
//        }
//        System.out.println("-------------Second Iterator-------------");
//        for (String r:randomizedQueue)
//        {
//            System.out.println(r);
//        }
//        System.out.println("-------------Third Iterator-------------");
//        for (String r:randomizedQueue)
//        {
//            System.out.println(r);
//        }
    Deque<String> deque = new Deque<>();
    Deque<Integer> deque1 = new Deque<>();
    deque.addFirst("to");
    deque.addFirst("be");
    deque1.addLast(1);
    deque1.addFirst(2);
    System.out.println(deque.removeFirst());
    System.out.println(deque.removeFirst());
    System.out.println(deque1.removeFirst());
    System.out.println(deque1.removeFirst());
    }
}
