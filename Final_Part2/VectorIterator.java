package Final_Part2;

import java.util.Iterator;
import java.util.Vector;

public class VectorIterator<T> extends IteratorOfIterators<T> implements Iterator<T>{

	private int current = 0;
	private Vector<T> it;
	
	public VectorIterator(){
		it = new Vector<T>();
	}
	
	public VectorIterator(Vector<T> vec){
		it = vec;
	}
	
	@Override
	public boolean hasNext() {
		return (it.elementAt(current) != null );
	}

	@Override
	public T next() {
		current += 1;
		return it.elementAt(current);
	}
	
	

}
