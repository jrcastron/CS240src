package sortingCode;

public class MergeSort extends sorting{
	int[] temp;
	
	public int[] iterativeAndRecursiveSort(int[] Array, int low, int high){
		if(low<high){
			int middle = low + (high-low)/2;
			Array = iterativeAndRecursiveSort(Array, low, middle);
			Array = iterativeAndRecursiveSort(Array, middle+1, high);
			Array = SortCall(Array, low, middle, high);
		}
		return Array;
	}
	
	public int[] SortCall(int[] Array, int low, int middle, int high){
		temp = new int[Array.length];
		for(int i = low; i <= high; i++){
			temp[i] = Array[i];
		}
		int i = low;
		int j = middle+1;
		int k = low;
		
		while((i<=middle)&&(j<=high)){
			countCompareI++;
			if(temp[i]<temp[j]){
				countMoveI++;
				Array[k] = temp[i];
				i++;
			}
			else{
				countMoveI++;
				Array[k] = temp[j];
				j++;
			}
			k++;
		}
		
		while(i<=middle){
			countMoveI++;
			Array[k] = temp[i];
			k++;
			i++;
		}
		
		return Array;
	}

}
