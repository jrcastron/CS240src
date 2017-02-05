package sortingCode;

import java.io.*;
import java.util.*;

public class Main {
	private static selectiveSort ss = new selectiveSort();
	
	public static void main( String args[] )throws IOException{
	
	int sizeR = 10;
	int sizeI = 10;
	int countMove = 0;
	int countCompare = 0;
	int[] aI;
	int[] aR;
	PrintWriter outFile = new PrintWriter(new FileWriter("CounterOutput.txt", false));
	
	aI = MakeArray(sizeI);
	aR = MakeArray(sizeR);
	aI = ss.iterativeSort(aI, sizeI);
	aR = ss.recursiveSort(aR, 0, 1, aR[0], 0);
	System.out.println("Array after selective iterative sort");
	DisplayArray(aI);
	System.out.println("Array after selective recursive sort");
	DisplayArray(aR);

}
	
	private static int[] MakeArray(int size){
		Random r = new Random();
		int[] Array = new int[size];
		for(int i = 0; i < size; i++){
			Array[i] = r.nextInt(1000);
		}
		return Array;
	}
	
	private static void DisplayArray(int[] Array){
		for(int i = 0; i < Array.length; i++){
			System.out.println(Array[i]);
		}
	}
}

