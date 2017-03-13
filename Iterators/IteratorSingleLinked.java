package Iterators;

import java.util.Iterator;

import Stack.Node;

public class IteratorSingleLinked<T> implements Iterator<T>{

	private Node<T> currentIndex;
	
	public IteratorSingleLinked(){
		currentIndex = null;
	}
	
	public IteratorSingleLinked(Node<T> first){
		currentIndex = new Node<T>(null, first);
	}
	
	@Override
	public boolean hasNext() {
		return (currentIndex.next != null);
	}

	@Override
	public T next() {
		if(hasNext()){
			currentIndex = currentIndex.next;
			return currentIndex.getData();
		}
		return null;
	}
	
	

}
