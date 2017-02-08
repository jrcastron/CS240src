package Queue;

import Stack.Node;

public class SingleLinkedQueue<T> {
    private Node<T> front;
    private Node<T> back;
    
    public void SingleLinkedQueue(){
    	front = null;
    	back = null;
    }
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		if(isEmpty()){
			front = new Node<T>(newEntry, null);
			back = front;
		}
		else{
			back.next = new Node<T>(newEntry, null);
			back = back.next;
		}
	}
	
	/** Removes and returns the entry at the front of this queue.
	    @return  The object at the front of the queue. 
	    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue(){
		T Front = null;
		if(front!=back){
			Front = front.getData();
			front = front.next;
		}
		else{
			front = null;
		}
		return Front;
	}
	
	/**  Retrieves the entry at the front of this queue.
	    @return  The object at the front of the queue.
	    @throws  EmptyQueueException if the queue is empty. */
	public T getFront(){
		if(!isEmpty()){
			return front.getData();
		}
		return null;
	}
	
	/** Detects whether this queue is empty.
	    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		return front == null;
	}
	
	/** Removes all entries from this queue. */
	public void clear(){
		while(!isEmpty()){
			dequeue();
		}
	}

}
