package SortedList;

import java.util.Random;

public class TestSortedList {
	
	private static SortedListLinked<String> testLinked = new SortedListLinked<String>();
	private static SortedListLinked<Integer> testLinked1 = new SortedListLinked<Integer>();
	
	public static void main(String args[]){
		
		Initialize();
		testLinked();
		
	}
	
	public static void Initialize(){
    	Random r = new Random();
    	int x;
    	
		testLinked.add("A");
		testLinked.add("C");
		testLinked.add("B");
		testLinked.add("C");
		
		for(int i = 0; i < 10; i++){		
			x = r.nextInt(100);
			testLinked1.add(x);
		}
	}
	
	public static void testLinked(){
		testLinked.toArray();
		testLinked1.toArray();
		boolean a = testLinked.remove("A");
		int b = testLinked.getPosition("B");
		int c = testLinked1.getPosition(20);
		int d = testLinked1.getEntry(2);
		testLinked1.clear();
		boolean e = testLinked.isEmpty();
		boolean f = testLinked1.isEmpty();
		
		System.out.println("Test:\n" + a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f);
		
	}

}
