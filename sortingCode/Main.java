package sortingCode;

import java.io.*;
import java.util.*;

public class Main {
	private static selectiveSort ss = new selectiveSort();
	private static InsersionSort is = new InsersionSort();
	private static ShellSort shs = new ShellSort();
	private static MergeSort ms = new MergeSort();
	private static QuickSort qs = new QuickSort();
	private static RadixSort rs = new RadixSort();
	
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
	
	TestMerge();
	outFile.println("Shell Data:");
	outFile.println("countMove recursive: " + ms.getCountMoveR());
	outFile.println("countCompare recursive: " + ms.getCountCompareR());
	outFile.println("countMove iterative: " + ms.getCountMoveI());
	outFile.println("countCompare iterative: " + ms.getCountCompareI());
	
	TestQuick();
	outFile.println("Shell Data:");
	outFile.println("countMove recursive: " + qs.getCountMoveR());
	outFile.println("countCompare recursive: " + qs.getCountCompareR());
	outFile.println("countMove iterative: " + qs.getCountMoveI());
	outFile.println("countCompare iterative: " + qs.getCountCompareI());
	
	TestRadix();
	outFile.println("Shell Data:");
	outFile.println("countMove recursive: " + rs.getCountMoveR());
	outFile.println("countCompare recursive: " + rs.getCountCompareR());
	outFile.println("countMove iterative: " + rs.getCountMoveI());
	outFile.println("countCompare iterative: " + rs.getCountCompareI());

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
	
	/**
	 * the implementation of this method uses both recursive and iterative, not
	 *  just one or the other.
	 */
	private static void TestMerge(){
//		int sizeR = 10;
		int sizeI = 10;
//		int[] aR;
		int[] aI;
		
		aI = MakeArray(sizeI);
//		aR = MakeArray(sizeR);
		aI = ms.iterativeAndRecursiveSort(aI, 0, sizeI-1);
//		aR = ms.recursiveSort(aR, 0, sizeR-1);
		System.out.println("Array after merge iterative sort");
		DisplayArray(aI);
//		System.out.println("Array after merge recursive sort");
//		DisplayArray(aR);
	}
	
	/**
	 * the implementation of this method uses both recursive and iterative, not
	 *  just one or the other.
	 */
	private static void TestQuick(){
//		int sizeR = 10;
		int sizeI = 10;
//		int[] aR;
		int[] aI;
		
		aI = MakeArray(sizeI);
//		aR = MakeArray(sizeR);
		aI = qs.iterativeAndRecursiveSort(aI, 0, sizeI-1);
//		aR = qs.recursiveSort(aR, 0, sizeR-1);
		System.out.println("Array after quick iterative sort");
		DisplayArray(aI);
//		System.out.println("Array after quick recursive sort");
//		DisplayArray(aR);
	}
	
	private static void TestRadix(){
		int sizeR = 10;
		int sizeI = 10;
		int[] aR;
		int[] aI;
		
		aI = MakeArray(sizeI);
		aR = MakeArray(sizeR);
		aI = rs.iterativeSort(aI);
		aR = rs.recursiveSort(aR, 1);
		System.out.println("Array after radix iterative sort");
		DisplayArray(aI);
		System.out.println("Array after radix recursive sort");
		DisplayArray(aR);
	}
	
	
}

