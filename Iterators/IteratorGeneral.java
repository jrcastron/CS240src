package Iterators;

import java.util.Iterator;

public class IteratorGeneral<T> implements Iterator<T>{
	

	private T[] Array;
	private int currentIndex;
    
	public IteratorGeneral(){
		@SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[0]; // Unchecked cast
        Array = temp;
        currentIndex = 0;
	}
	
	public IteratorGeneral(T[] temp){
		Array = temp;
		currentIndex = -1;
	}

	@Override
	public boolean hasNext() {
		if(currentIndex + 1 < Array.length){
			for(int i = currentIndex + 1; i < Array.length; i++){
	        	if(Array[i] != null){
	        		return true;
	        	}
			}
        }
        return false;
	}

	@Override
	public T next() {
		if(hasNext()){
			for(int i = currentIndex + 1; i < Array.length; i++){
	        	if(Array[i] != null){
	        		currentIndex = i;
	        		break;
	        	}
			}
        	return Array[currentIndex];
        }
        return null;
	}


	
	

}
