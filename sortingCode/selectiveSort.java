package sortingCode;

import java.io.*;

public class selectiveSort {

	
	public int[] iterativeSort(int[] Array, int size)throws IOException{
		PrintWriter outFile = new PrintWriter(new FileWriter("CounterOutput.txt", false));
		int smallest = 0;
		int index = 0;
		for(int j = 0; j < size; j++){
			smallest = Array[j];
			for(int i = j; i < size; i++){
				if(Array[i]<smallest){
					smallest = Array[i];
					index = i;
				}
			}
			Array[index] = Array[j];
			Array[j] = smallest;
		}
		
		return Array;
	}
	
	public int[] recursiveSort(int[] Array, int first, int next, int smallest, int index){
		
		if(next<=Array.length-1){
			if(first==Array.length-1){
				return Array;
			}
			else{
				if(Array[next]<smallest){
					smallest = Array[next];
					index = next;
					if(next==Array.length-1){
						Array[index] = Array[first];
						Array[first] = smallest;
						Array = recursiveSort(Array, first+1, first+2, Array[first+1], index);
					}
					else{
						Array = recursiveSort(Array, first, next+1, smallest, index);
					}
				}
				else if(next==Array.length-1){
					if(smallest==Array[index]){
						Array[index] = Array[first];
						Array[first] = smallest;
						Array = recursiveSort(Array, first+1, first+2, Array[first+1], index);
					}
					else{
						Array = recursiveSort(Array, first+1, first+2, Array[first+1], index);
					}
				}
				else {
					Array = recursiveSort(Array, first, next+1, smallest, index);
				}
			}
		}
		return Array;
	}
	
}


