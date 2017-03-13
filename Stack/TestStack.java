package Stack;

import java.util.Iterator;
import java.util.Random;

public class TestStack {
	private static ArrayStack<String> testArray = new ArrayStack<String>(10);
	private static VectorStack<String> testVector = new VectorStack<String>();
	private static LinkedDataStack<String> testLinked = new LinkedDataStack<String>();
	private static ArrayStack<Integer> testArray1 = new ArrayStack<Integer>(10);
	private static VectorStack<Integer> testVector1 = new VectorStack<Integer>();
	private static LinkedDataStack<Integer> testLinked1 = new LinkedDataStack<Integer>();
	
    public static void main(String args[]) {
    	
    	Initialize();
    	testIterator();
    	Peek();
    	pop();
    	Peek();
    	clear();
    	Peek();
    	testIterator();
    }
    
    public static void Initialize(){
    	Random r = new Random();
    	
    	testArray.push("A");
    	testArray.push("B");
    	testArray.push("C");
    	
    	testVector.push("A");
    	testVector.push("B");
    	testVector.push("C");
    	
    	testLinked.push("A");
    	testLinked.push("B");
    	testLinked.push("C");
    	
    	for(int i = 0; i < 10; i++){
    		testArray1.push(r.nextInt(100));
    		testVector1.push(r.nextInt(100));
    		testLinked1.push(r.nextInt(100));
    	}
    }
    
    public static void Peek(){
    	System.out.println("Array string lastAdded: " + testArray.peek());
    	System.out.println("Vector string lastAdded: " + testVector.peek());
    	System.out.println("Linked string lastAdded: " + testLinked.peek());
    	System.out.println("Array int lastAdded: " + testArray1.peek());
    	System.out.println("Vector int lastAdded: " + testVector1.peek());
    	System.out.println("Linked int lastAdded: " + testLinked1.peek());
    }
    
    public static void pop(){
    	System.out.println("Array string removed: " + testArray.pop());
    	System.out.println("Vector string removed: " + testVector.pop());
    	System.out.println("Linked string removed: " + testLinked.pop());
    	System.out.println("Array int removed: " + testArray1.pop());
    	System.out.println("Vector int removed: " + testVector1.pop());
    	System.out.println("Linked int removed: " + testLinked1.pop());
    }
    
    public static void clear(){
    	testArray.clear();
    	testVector.clear();
    	testLinked.clear();
    	testArray1.clear();
    	testVector1.clear();
    	testLinked1.clear();
    }
    
    public static void testIterator(){
		System.out.println("=================Iterator test============");
		Iterator<String> c = testArray.getIterator();
    	Iterator<Integer> d = testArray1.getIterator();
    	System.out.print("iterator one: ");
    	while(d.hasNext()){
    		System.out.print(d.next() + " ");
    	}
    	System.out.println();
    	System.out.print("iterator two: ");
    	while(c.hasNext()){
    		System.out.print(c.next() + " ");
    	}
    	System.out.println();
	}

}
