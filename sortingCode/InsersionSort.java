package sortingCode;

public class InsersionSort extends sorting{
	int pointer = 0;
	
	public int[] iterativeSort(int[] Array){
		int temp = 0;
		while(pointer<Array.length-1){
			countCompareI++;
			if(Array[pointer+1]<Array[pointer]){
				temp = Array[pointer];
				Array[pointer] = Array[pointer+1];
				Array[pointer+1] = temp;
				countMoveI++;
			}
			for(int i = 0; i < pointer; i++){
				for(int j = i; j <= pointer; j++){
					countCompareI++;
					if(Array[j]<Array[i]){
						temp = Array[i];
						Array[i] = Array[j];
						Array[j] = temp;
						countMoveI++;
					}
				}
			}
			pointer++;
		}
		pointer = 0;
		return Array;
	}
	
	public int[] recursiveSort(int[] Array, int first, int next){
		int temp = 0;
		if(pointer==Array.length-1){
			pointer = 0;
			return Array;
		}
		else if(Array[pointer+1] < Array[pointer]){
			countCompareR++;
			temp = Array[pointer];
			Array[pointer] = Array[pointer+1];
			Array[pointer+1] = temp;
			countMoveR++;
		}
		if(first<pointer){
			if(next<=pointer){
				countCompareR++;
				if(Array[next] < Array[first]){
					temp = Array[first];
					Array[first] = Array[next];
					Array[next] = temp;
					countMoveR++;
					return recursiveSort(Array, first, next+1);
				}
				else{
					return recursiveSort(Array, first, next+1);
				}
			}
			else{
				return recursiveSort(Array, first+1, first+1);
			}
		}
		else{
			pointer++;
			return recursiveSort(Array, 0, 0);
		}
	}

}
