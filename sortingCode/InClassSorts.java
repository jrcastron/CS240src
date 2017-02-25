package sortingCode;

public class InClassSorts {
	
	public int[] ItSelective(int[] Array){
		for(int i = 0; i < Array.length; i++){
			for(int j = i + 1; j < Array.length; j++){
				if(Array[j] < Array[i]){
					int temp = Array[j];
					Array[j] = Array[i];
					Array[i] = temp;
				}
			}
		}
		return Array;
	}
	
	public int[] ReSelective(int[] Array, int first, int comp){
		if(first == Array.length-1){
			return Array;
		}
		if(Array[comp] < Array[first]){
			int temp = Array[comp];
			Array[comp] = Array[first];
			Array[first] = temp;
		}
		if(comp == Array.length-1){
			Array = ReSelective(Array, first+1, first+2);
		}
		else{
			Array = ReSelective(Array, first, comp + 1);
		}
		
		return Array;
	}
	
	public int[] ItInsertion(int[] Array){
		//i = next pointer
		for(int i = 1; i < Array.length; i++){
			int sortedElement = Array[i];
			int j = i - 1;
			while((j >= 0)&&(sortedElement < Array[j])){
				//Shift
				Array[j+1] = Array[j];
				j--;
			}
			Array[j+1] = sortedElement;
		}
		return Array;
	}
	
	//backwards: i starts at end
	//doesnt sort
	public void ReInsertion(int[] Array, int i){
		int j = i - 1;
		int sortedElement = Array[i];
		//base case
		if(i > 1){
			i--;
			ReInsertion(Array, i);
		}
		else{
			while((j >= 0)&&(sortedElement < Array[j])){
				//Shift
				Array[j+1] = Array[j];
				j--;
			}
		}
		Array[j+1] = sortedElement;
	}

}
