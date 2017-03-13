package Stack;

import java.util.Iterator;

import Iterators.IteratorSingleLinked;

public final class LinkedDataStack<T> implements StackInterface<T>{
    private Node<T> topNode;
    
    /** initializes any variables. */
    public void LinkedDataStackStack() {
    	topNode = null;
    } // end default constructor
    
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry){
		   if(topNode == null){
		       topNode = new Node<T>(newEntry, topNode);
		   }
		   else
		   {
		      Node<T> tmp = topNode;
		      while(tmp.next != null){
		    	  tmp = tmp.next;
		      }
		      tmp.next = new Node<T>(newEntry, null);
		   }
	}
	
	public void pushInClass(T newEntry){
		topNode = new Node<T>(newEntry, topNode);
	}
	
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty(){
        return topNode == null;
    } // end isEmpty
	
	/** Removes and returns this stack's top entry.
	    @return  The object at the top of the stack. 
	    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop(){
		if(topNode == null) throw new RuntimeException("cannot delete");
		T last = peek();
		if(topNode.next == null){
			topNode = null;
			return null;
		   }
		   else
		   {
		      Node<T> tmp = topNode;
		      Node<T> previouse = null;
		      while(tmp.next != null){
		    	  previouse = tmp;
		    	  tmp = tmp.next;
		      }
		      previouse.next = tmp.next;
		   }
		return last;
	}
	
	public T popInClass(){
		T top = peek();
		assert(topNode != null);
		topNode = topNode.getNextNode();
		return top;
	}
	
	/** Retrieves this stack's top entry.
	    @return  The object at the top of the stack.
	    @throws  EmptyStackException if the stack is empty. */
	public T peek(){
		if(!isEmpty()){
			Node<T> tmp = topNode;
		      while(tmp.next != null){
		    	  tmp = tmp.next;
		      }
		      tmp.next = null;
			return tmp.getData();
		}
		return null;
	}
	
	public int getLength(){
		int length = 0;
		Node<T> tmp = topNode;
		if(!isEmpty()){
			while(tmp.getNextNode() != null){
				length++;
				tmp = tmp.next;
			}
		}
		return length;
	}
	
	/** Removes all entries from this stack. */
	public void clear(){
		while (!isEmpty()) {
			pop();
		}
	}
	
	public Iterator<T> getIterator(){
		return new IteratorSingleLinked<T>(topNode);
	}

}
