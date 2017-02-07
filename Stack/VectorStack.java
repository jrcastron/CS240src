package Stack;

import java.util.Vector;

public final class VectorStack<T> implements StackInterface<T>{
    private final Vector<T> Stack;
    
    /** Creates an empty stack. */
	public VectorStack() {
        Vector<T> tempStack = new Vector<T>();
    	Stack = tempStack;
    } // end default constructor
    
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry){
            Stack.addElement(newEntry);
	}
	
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty(){
        return Stack.isEmpty();
    } // end isEmpty

    /** Gets the current number of entries in this stack.
    @return The integer number of entries currently in the bag. */
    public int getCurrentSize() {
        return Stack.size();
    } // end getCurrentSize
	
	/** Removes and returns this stack's top entry.
	    @return  The object at the top of the stack. 
	    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop(){
		if(!isEmpty()){
			
			T top = Stack.lastElement();
			Stack.remove(Stack.lastElement());
			return top;
		}
		return null;
	}
	
	/** Retrieves this stack's top entry.
	    @return  The object at the top of the stack.
	    @throws  EmptyStackException if the stack is empty. */
	public T peek(){
		if(!isEmpty()){
			return Stack.lastElement();
		}
		return null;
	}
	
	
	/** Removes all entries from this stack. */
	public void clear(){
		Stack.clear();
	}
}
