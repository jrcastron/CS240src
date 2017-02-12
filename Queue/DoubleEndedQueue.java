package Queue;

import Stack.Node;

public class DoubleEndedQueue<T> implements QueueInterface<T>{
	private DoubleLinkedNode<T> front;
	private DoubleLinkedNode<T> back;
	
	public DoubleEndedQueue(){
		front = null;
		back = null;
	}
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		if(isEmpty()){
			front = new DoubleLinkedNode<T>(null, newEntry, front);
			back = front;
		}
		else{
			back.next = new DoubleLinkedNode<T>(back, newEntry, null);
			back = back.next;
		}
	}
	
	/** Removes and returns the entry at the front of this queue.
	    @return  The object at the front of the queue. 
	    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue(){
		T top = null;
		if(!isEmpty()){
			top = front.getData();
			front = front.next;
		}
		else{
			top = null;
		}
		return top;
	}
	
	/**  Retrieves the entry at the front of this queue.
	    @return  The object at the front of the queue.
	    @throws  EmptyQueueException if the queue is empty. */
	public T getFront(){
		if(!isEmpty()){
			return front.getData();
		}
		else{
			return null;
		}
	}
	
	/** Detects whether this queue is empty.
	    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		if(front == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** Removes all entries from this queue. */
	public void clear(){
		while(!isEmpty()){
			dequeue();
		}
	}

}
