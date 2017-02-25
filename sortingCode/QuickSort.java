package sortingCode;
import Lab3_InNOut.Food;

public class QuickSort extends sorting{
	
	public int[] iterativeAndRecursiveSort(int[] Array, int lower, int higher){
		int pivot = Array[lower + (higher-lower)/2];
		int i = lower;
		int j = higher;
		
		while(i<=j){
			countCompareI++;
			while(Array[i]<pivot){
				countCompareI++;
				i++;
			}
			while(Array[j]>pivot){
				countCompareI++;
				j--;
			}
			if(i<=j){
				countMoveI++;
				int temp = Array[i];
				Array[i] = Array[j];
				Array[j] = temp;
				i++;
				j--;
			}
		}
		if(lower < j){
			Array = iterativeAndRecursiveSort(Array, lower, j);
		}
		if(i < higher){
			Array = iterativeAndRecursiveSort(Array, i, higher);
		}
		
		return Array;
	}
	
	public Food[] FoodSort(Food[] Array, int lower, int higher){
		int pivot = Array[lower + (higher-lower)/2].getExp();
		int i = lower;
		int j = higher;
		
		while(i<=j){
			countCompareI++;
			while(Array[i].getExp()<pivot){
				countCompareI++;
				i++;
			}
			while(Array[j].getExp()>pivot){
				countCompareI++;
				j--;
			}
			if(i<=j){
				countMoveI++;
				Food temp = Array[i];
				Array[i] = Array[j];
				Array[j] = temp;
				i++;
				j--;
			}
		}
		if(lower < j){
			Array = FoodSort(Array, lower, j);
		}
		if(i < higher){
			Array = FoodSort(Array, i, higher);
		}
		
		return Array;
	}

}
