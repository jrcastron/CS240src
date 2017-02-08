package sortingCode;

import java.io.*;
import java.util.*;

public class Main {
	private static selectiveSort ss = new selectiveSort();
	private static InsersionSort is = new InsersionSort();
	private static ShellSort shs = new ShellSort();
	
	public static void main( String args[] )throws IOException{

	PrintWriter outFile = new PrintWriter(new FileWriter("CounterOutput.txt", false));
	
	TestSelective();
	outFile.println("Selective Data:");
	outFile.println("countMove recursive: " + ss.getCountMoveR());
	outFile.println("countCompare recursive: " + ss.getCountCompareR());
	outFile.println("countMove iterative: " + ss.getCountMoveI());
	outFile.println("countCompare iterative: " + ss.getCountCompareI());
	
	TestInsertion();
	outFile.println("Insertion Data:");
	outFile.println("countMove recursive: " + is.getCountMoveR());
	outFile.println("countCompare recursive: " + is.getCountCompareR());
	outFile.println("countMove iterative: " + is.getCountMoveI());
	outFile.println("countCompare iterative: " + is.getCountCompareI());
	
	TestShell();
	outFile.println("Shell Data:");
	outFile.println("countMove recursive: " + shs.getCountMoveR());
	outFile.println("countCompare recursive: " + shs.getCountCompareR());
	outFile.println("countMove iterative: " + shs.getCountMoveI());
	outFile.println("countCompare iterative: " + shs.getCountCompareI());

	outFile.close();
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
	
	private static void TestSelective(){
		int sizeR = 10;
		int sizeI = 10;
		int[] aI;
		int[] aR;
		
		aI = MakeArray(sizeI);
		aR = MakeArray(sizeR);
		aI = ss.iterativeSort(aI);
		aR = ss.recursiveSort(aR, 0, 0);
		System.out.println("Array after selective iterative sort");
		DisplayArray(aI);
		System.out.println("Array after selective recursive sort");
		DisplayArray(aR);
	}
	
	private static void TestInsertion(){
		int sizeR = 10;
		int sizeI = 10;
		int[] aR;
		int[] aI;
		
		aI = MakeArray(sizeI);
		aR = MakeArray(sizeR);
		aI = is.iterativeSort(aI);
		aR = is.recursiveSort(aR, 0, 0);
		System.out.println("Array after insertion iterative sort");
		DisplayArray(aI);
		System.out.println("Array after insertion recursive sort");
		DisplayArray(aR);
	}
	
	private static void TestShell(){
		int sizeR = 10;
		int sizeI = 10;
		int[] aR;
		int[] aI;
		
		aI = MakeArray(sizeI);
		int spaces = shs.GetSpaces(sizeI);
		aR = MakeArray(sizeR);
		aI = shs.iterativeSort(aI, spaces);
		spaces = shs.GetSpaces(sizeR);
		aR = shs.recursiveSort(aR, spaces, 0, spaces);
		System.out.println("Array after Shell iterative sort");
		DisplayArray(aI);
		System.out.println("Array after Shell recursive sort");
		DisplayArray(aR);
	}
	
	
}

