package Final_Part2;

import java.util.Iterator;

import Stack.Node;

public class LinkedIterator<T> extends IteratorOfIterators<T> implements Iterator<T>{
	
private Node<T> currentIndex;
	
	public LinkedIterator(){
		currentIndex = null;
	}
	
	public LinkedIterator(Node<T> first){
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
