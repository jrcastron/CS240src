package sortingCode;

public class ShellSort extends sorting {
	
	public int GetSpaces(int size){
		for(int i = 0; i < size; i++){
			if(size < (2*i+1)){
				return (i-2)*2+1;
			}
		}
		return 0;
	}
	
	public int[] iterativeSort(int[] Array, int spaces){
		int temp = 0;
		do{
			for(int i = 0; i < Array.length; i += spaces){
				for(int j = i + spaces; j < Array.length; j += spaces){
					countCompareI++;
					if(Array[j]<Array[i]){
						countMoveI++;
						temp = Array[i];
						Array[i] = Array[j];
						Array[j] = temp;
					}
				}
			}
			spaces = (spaces-1)/2;
		}while(spaces>0);
		
		return Array;
	}
	
	public int[] recursiveSort(int[] Array, int spaces, int first, int next){
		int temp = 0;
		if(spaces<=0){
			return Array;
		}
		else if(first<Array.length){
			if(next<Array.length){
				countCompareR++;
				if(Array[next]<Array[first]){
					countMoveR++;
					temp = Array[next];
					Array[next] = Array[first];
					Array[first] = temp;
				}
				return recursiveSort(Array, spaces, first, next+spaces);
			}
			else{
				return recursiveSort(Array, spaces, first+spaces, first+(spaces*2));
			}
		}
		else{
			spaces = (spaces-1)/2;
			return recursiveSort(Array, spaces, 0, spaces);
		}
	}

}
