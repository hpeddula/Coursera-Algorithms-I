public class Main {

    public static void main(String[] args) {
	// write your code here
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("to");
        randomizedQueue.enqueue("be");
        randomizedQueue.enqueue("or");
        randomizedQueue.enqueue("not");
        randomizedQueue.enqueue("h1");
        randomizedQueue.enqueue("h2");
        randomizedQueue.enqueue("h3");
        randomizedQueue.enqueue("h4");
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
//        randomizedQueue.dequeue();
        randomizedQueue.enqueue("h5");
        randomizedQueue.enqueue("h6");
        randomizedQueue.enqueue("h7");
        randomizedQueue.enqueue("h8");
        System.out.println("-------------First Iterator-----------");
        for (String r:randomizedQueue)
        {
            System.out.println(r);
        }
        System.out.println("-------------Second Iterator-------------");
        for (String r:randomizedQueue)
        {
            System.out.println(r);
        }
        System.out.println("-------------Third Iterator-------------");
        for (String r:randomizedQueue)
        {
            System.out.println(r);
        }
    }
}
