package List;

import java.util.Random;

public class TestList {
	
	private static ListVector<String> testVector = new ListVector<String>();
	private static ListVector<Integer> testVector1 = new ListVector<Integer>();
	
	public static void main(String args[]){
		
		Initialize();
		testVector();
		
	}
	
	public static void Initialize(){
    	Random r = new Random();
    	
    	testVector.Add("A");
    	testVector.Add("B");
    	testVector.Add("C");
    	
    	for(int i = 0; i < 10; i++){
    		testVector1.Add(r.nextInt(100));
    	}
	}
	
	public static void testVector(){
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

}
