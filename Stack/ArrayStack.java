package Stack;

public final class ArrayStack<T> implements StackInterface<T>{
	private final T[] Stack;
    private int topIndex;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    /** Creates an empty stack whose initial capacity is 10. */
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates an empty stack having a given initial capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayStack(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[]) new Object[desiredCapacity]; // Unchecked cast
            Stack = tempStack;
            topIndex = -1;
        }
        else
            throw new IllegalStateException("Attempt to create a stack " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end constructor
    
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry){
        if (topIndex < Stack.length) {
            Stack[topIndex + 1] = newEntry;
            topIndex++;
        } // end if
	}
	
	/** Detects whether this stack is empty.
    @return  True if the stack is empty. */
	public boolean isEmpty(){
        return topIndex == -1;
    } // end isEmpty

    /** Gets the current number of entries in this stack.
    @return The integer number of entries currently in the bag. */
    public int getCurrentSize() {
        return topIndex + 1;
    } // end getCurrentSize
	
	/** Removes and returns this stack's top entry.
	    @return  The object at the top of the stack. 
	    @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop(){
		if(!isEmpty()){
			T top = Stack[topIndex];
			Stack[topIndex] = null;
			topIndex--;
			return top;
		}
		return null;
	}
	
	/** Retrieves this stack's top entry.
	    @return  The object at the top of the stack.
	    @throws  EmptyStackException if the stack is empty. */
	public T peek(){
		if(!isEmpty()){
			return Stack[topIndex];
		}
		return null;
	}
	
	
	/** Removes all entries from this stack. */
	public void clear(){
		while (!isEmpty()) {
			pop();
		}
	}
}
