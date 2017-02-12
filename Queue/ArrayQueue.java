package Queue;

public class ArrayQueue<T> implements QueueInterface<T>{
	private final T[] Queue;
    private int back;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    /** Creates an empty stack whose initial capacity is 10. */
    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    
    /**
     * Creates an empty stack having a given initial capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ArrayQueue(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempStack = (T[]) new Object[desiredCapacity]; // Unchecked cast
            Queue = tempStack;
            back = -1;
        }
        else
            throw new IllegalStateException("Attempt to create a Queue " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end constructor
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		if(back+1<Queue.length){
			Queue[back+1] = newEntry;
			back++;
		}
	}
	
	/** Removes and returns the entry at the front of this queue.
	    @return  The object at the front of the queue. 
	    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue(){
		T Front = null;
		if(!isEmpty()){
			Front = Queue[0];
			for(int i = 0; i < back; i++){
				Queue[i] = Queue[i+1];
			}
			Queue[back] = null;
			back--;
		}
		return Front;
	}
	
	/**  Retrieves the entry at the front of this queue.
	    @return  The object at the front of the queue.
	    @throws  EmptyQueueException if the queue is empty. */
	public T getFront(){
		if(!isEmpty()){
			return Queue[0];
		}
		return null;
	}
	
	/** Detects whether this queue is empty.
	    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		return (back<0);
	}
	
	/** Removes all entries from this queue. */
	public void clear(){
		while(!isEmpty()){
			dequeue();
		}
	}

}
