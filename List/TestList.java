package List;

import java.util.Random;

public class TestList {
	
	private static ListVector<String> testVector = new ListVector<String>();
	private static ListVector<Integer> testVector1 = new ListVector<Integer>();
	private static LinkedList<String> testLinked = new LinkedList<String>();
	private static LinkedList<Integer> testLinked1 = new LinkedList<Integer>();
	
	public static void main(String args[]){
		
		Initialize();
		testVector();
		testLinked();
		
	}
	
	public static void Initialize(){
    	Random r = new Random();
    	
    	testVector.Add("A");
    	testVector.Add("B");
    	testVector.Add("C");
    	testLinked.Add("A");
    	testLinked.Add("B");
    	testLinked.Add("C");
    	
    	for(int i = 0; i < 10; i++){
    		testVector1.Add(r.nextInt(100));
    		testLinked1.Add(r.nextInt(100));
    	}
	}
	
	public static void testVector(){
		System.out.println("Test Vector: ");
		testVector.LookAtAll();
		boolean a = testVector.Add("X", 2);
		boolean b = testVector1.Add(-5, 2);
		String c = testVector.LookAtItem("X");
		int d = testVector1.LookAtItem(-5);
		String e = testVector.Remove("A");
		int f = testVector1.Remove(5);
		testVector1.LookAtAll();
		int g = testVector.FindItem("A");
		int h = testVector1.CountEntries();
		String i = testVector.replaceItem("Y", "B");
		String j = testVector.replaceItem("Y", "C");
		testVector.LookAtAll();
		testVector1.clear();
		boolean l = testVector1.isEmpty();
		
		System.out.println("is: \n" + a + "\n" + b + "\n" + c + "\n" + d +"\n" 
		+ e + "\n" + f + "\n" + g + "\n" + h + "\n" + i + "\n" + j + "\n" + l);
	}
	
	public static void testLinked(){
		System.out.println("Test Linked: ");
		testLinked.LookAtAll();
		boolean a = testLinked.Add("X", 2);
		boolean b = testLinked1.Add(-5, 2);
		String c = testLinked.LookAtItem("X");
		int d = testLinked1.LookAtItem(-5);
		String e = testLinked.Remove("A");
		int f = testLinked1.Remove(5);
		testLinked1.LookAtAll();
		testLinked.LookAtAll();
		int g = testLinked.FindItem("A");
		int h = testLinked1.CountEntries();
		String i = testLinked.replaceItem("Y", "B");
		String j = testLinked.replaceItem("Y", "C");
		testLinked.LookAtAll();
		testLinked1.clear();
		boolean l = testLinked1.isEmpty();
		
		System.out.println("is: \n" + a + "\n" + b + "\n" + c + "\n" + d +"\n" 
		+ e + "\n" + f + "\n" + g + "\n" + h + "\n" + i + "\n" + j + "\n" + l);
	}

}
