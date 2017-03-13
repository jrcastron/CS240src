package Dictionary;

import java.util.Iterator;

import List.ListVector;

public class testDictionary{
	private static LinkedDictionary<Integer, String> linkedTest = new LinkedDictionary<Integer, String>();
	
    public static void main(String args[]) {
    	
    	initialize();
    	test();
    	
    }
    
    public static void initialize(){
    	linkedTest.add(1, "one");
    	linkedTest.add(1, "uno");
    	linkedTest.add(1, "ichi");
    	linkedTest.add(2, "two");
    	linkedTest.add(2, "nii");
    }
    
    public static void test(){
    	int a = linkedTest.getSize();
    	boolean b = linkedTest.contains(3);
    	Iterator<String> c = linkedTest.getValueIterator();
    	Iterator<Integer> d = linkedTest.getKeyIterator();
    	System.out.print("Keys: ");
    	while(d.hasNext()){
    		System.out.print(d.next() + " ");
    	}
    	System.out.println();
    	System.out.print("Values: ");
    	while(c.hasNext()){
    		System.out.print(c.next() + " ");
    	}
    	System.out.println();
    	linkedTest.getValue(1);
    	linkedTest.clear();
    	boolean e = linkedTest.isEmpty();
    	
    	System.out.println(a + "\n" + b + "\n" + e);
    }

}
