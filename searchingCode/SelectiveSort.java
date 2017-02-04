package searchingCode;

import java.util.Random;

public class SelectiveSort {
	Random r;
	int[] Array;
	
	public void SelectiveSort(){
		Array = new int[10];
		r = new Random();
		for(int i = 0; i < 10; i++){
			Array[i] = r.nextInt(101);
		}
		
	}
	
	private int[] iterativeSort(){
		int smallest = 0;
		int index = 0;
		for(int j = 0; j < 9; j++){
			smallest = Array[j];
			for(int i = 1; i < 9; i++){
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
	
}

