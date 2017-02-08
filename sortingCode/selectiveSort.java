package sortingCode;

public class selectiveSort extends sorting{
	
	public int[] iterativeSort(int[] Array, int size){
		int smallest = 0;
		int index = 0;
		for(int j = 0; j < size; j++){
			smallest = Array[j];
			for(int i = j; i < size; i++){
				countCompareI++;
				if(Array[i]<smallest){
					smallest = Array[i];
					index = i;
					countMoveI++;
				}
			}
			Array[index] = Array[j];
			Array[j] = smallest;
		}
		return Array;
	}
	
	public int[] recursiveSort(int[] Array, int first, int last){
		if(last<Array.length){
			if(first == Array.length - 1){
				return Array;
			}
			else{
				countCompareR++;
				int temp = Array[first];
				if(Array[last]<Array[first]){
					countMoveR++;
					Array[first] = Array[last];
					Array[last] = temp;
					if(last == Array.length - 1){
						Array = recursiveSort(Array, first+1, first+2);
					}
					Array = recursiveSort(Array, first, last+1);
				}
				else if(last == Array.length - 1){
					Array = recursiveSort(Array, first+1, first+2);
				}
				else{
					Array = recursiveSort(Array, first, last+1);
				}
			}
		}
		return Array;
	}
	
}


