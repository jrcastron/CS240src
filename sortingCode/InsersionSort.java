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
			for(int i = pointer; i >0; i--){
					countCompareI++;
					int j = i-1;
					if(j>0){
						while((Array[i]<Array[j])&&(j>0)){
							countCompareI++;
							temp = Array[i];
							Array[i] = Array[j];
							Array[j] = temp;
							countMoveI++;
							j--;
						}
					}
					else if(j==0){
						if(Array[i]<Array[j]){
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
		if(first>0){
			countCompareR++;
			if(next>0){
				countCompareR++;
				if(Array[first] < Array[next]){
					temp = Array[first];
					Array[first] = Array[next];
					Array[next] = temp;
					countMoveR++;
					return recursiveSort(Array, first-1, next-1);
				}
				else{
					pointer++;
					return recursiveSort(Array, pointer, pointer-1);
				}
			}
			else if(Array[first] < Array[next]){
				temp = Array[first];
				Array[first] = Array[next];
				Array[next] = temp;
				countMoveR++;
				pointer++;
				return recursiveSort(Array, pointer, pointer-1);
			}
			else{
				pointer++;
				return recursiveSort(Array, pointer, pointer-1);
			}
		}
		else{
			pointer++;
			return recursiveSort(Array, pointer, pointer-1);
		}
	}

}
