package Final_Part2;

import java.util.LinkedList;
import java.util.Vector;

import Stack.Node;

//import java.util.Iterator;

public class Iterator<T> {
	
	private LinkedList<IteratorOfIterators<T>> it = new LinkedList<IteratorOfIterators<T>>();
	private IteratorOfIterators<T> I;
	
	public Iterator(T[] Array){
		I = new ArrayIt<T>(Array);
		it.push(I);
	}
	
	public Iterator(Node<T> first){
		I = new LinkedIterator<T>(first);
		it.push(I);
	}

	public Iterator(Vector<T> vec){
		I = new VectorIterator<T>(vec);
		it.add(I);
	}
	
	public boolean hasNext(){
		return (it.iterator().hasNext());
	}
	
	public IteratorOfIterators<T> next(){
		return it.iterator().next();
	}
	
}
