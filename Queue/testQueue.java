package Queue;

import java.util.Random;

public class testQueue {
	
	private static ArrayQueue<String> testArray = new ArrayQueue<String>(10);
	private static ArrayQueue<Integer> testArray1 = new ArrayQueue<Integer>(10);
	private static SingleLinkedQueue<String> testSingleLinked = new SingleLinkedQueue<String>();
	private static SingleLinkedQueue<Integer> testSingleLinked1 = new SingleLinkedQueue<Integer>();
	private static DoubleLinkedQueue<String> testDoubleLinked = new DoubleLinkedQueue<String>(10);
	private static DoubleLinkedQueue<Integer> testDoubleLinked1 = new DoubleLinkedQueue<Integer>(10);

    public static void main(String args[]) {
    	
    	Initialize();
    	getFront();
    	dequeue();
    	getFront();
    	clear();
    	getFront();
    	
    }
    
    public static void Initialize(){
    	Random r = new Random();
    	
    	testArray.enqueue("A");
    	testArray.enqueue("B");
    	testArray.enqueue("C");

    	testSingleLinked.enqueue("A");
    	testSingleLinked.enqueue("B");
    	testSingleLinked.enqueue("C");
    	
    	testDoubleLinked.enqueue("A");
    	testDoubleLinked.enqueue("B");
    	testDoubleLinked.enqueue("C");
    	
    	for(int i = 0; i < 10; i++){
    		testArray1.enqueue(r.nextInt(100));
    		testSingleLinked1.enqueue(r.nextInt(100));
    		testDoubleLinked1.enqueue(r.nextInt(100));
    	}
    }
    
    public static void getFront(){
    	System.out.println("Array string lastAdded: " + testArray.getFront());
    	System.out.println("Single Linked string lastAdded: " + testSingleLinked.getFront());
    	System.out.println("Double Linked string lastAdded: " + testDoubleLinked.getFront());
    	System.out.println("Array int lastAdded: " + testArray1.getFront());
    	System.out.println("Single Linked int lastAdded: " + testSingleLinked1.getFront());
    	System.out.println("Double Linked int lastAdded: " + testDoubleLinked1.getFront());
    }
    
    public static void dequeue(){
    	System.out.println("Array string removed: " + testArray.dequeue());
    	System.out.println("Single Linked string removed: " + testSingleLinked.dequeue());
    	System.out.println("Double Linked string removed: " + testDoubleLinked.dequeue());
    	System.out.println("Array int removed: " + testArray1.dequeue());
    	System.out.println("Single Linked int removed: " + testSingleLinked1.dequeue());
    	System.out.println("Double Linked int removed: " + testDoubleLinked1.dequeue());
    }
    
    public static void clear(){
    	testArray.clear();
    	testSingleLinked.clear();
    	testDoubleLinked.clear();
    	testArray1.clear();
    	testSingleLinked1.clear();
    	testDoubleLinked1.clear();
    }

}
