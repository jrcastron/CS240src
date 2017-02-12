package Queue;

import Stack.Node;

public class DoubleLinkedQueue<T> implements QueueInterface<T>{
	private Node<T> back;
	private Node<T> free;
	private int size;
	private int numItems = 0;
    private static final int DEFAULT_SIZE = 10;
    private static final int MAX_SIZE = 10;
	
	public DoubleLinkedQueue(){
		this(DEFAULT_SIZE);
	}
	
	public DoubleLinkedQueue(int desiredSize){
		if(desiredSize <= MAX_SIZE){
			free = new Node<T>(null, free);
			size = desiredSize;
			back = null;
		}
		else
            throw new IllegalStateException("Attempt to create a Queue " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
	}
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry){
		if(isEmpty()){
			back = new Node<T>(newEntry, free);
			free.next = back;
			numItems++;
		}
		else if(free.next.getData()==null){
			Node<T> temp = free.next;
			while(temp.next.getData()==null){
				temp = temp.next;
			}
			temp.data = newEntry;
			numItems++;
		}
		else if(numItems < size){
			Node<T> temp = new Node<T>(newEntry, back);
			back = temp;
			free.next = back;
			numItems++;
		}
	}
	
	/** Removes and returns the entry at the front of this queue.
	    @return  The object at the front of the queue. 
	    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue(){
		T Front = null;
		Node<T> temp = back;
		if(!isEmpty()){
			while(temp.next.getData() != null){
				temp = temp.next;
			}
			Front = temp.getData();
			temp.data = null;
			free = temp;
			numItems--;
		}
		return Front;
	}
	
	/**  Retrieves the entry at the front of this queue.
	    @return  The object at the front of the queue.
	    @throws  EmptyQueueException if the queue is empty. */
	public T getFront(){
		Node<T> temp = back;
		while(temp.next.getData() != null){
			temp = temp.next;
		}
		return temp.getData();
	}
	
	/** Detects whether this queue is empty.
	    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty(){
		return (numItems == 0);
	}
	
	/** Removes all entries from this queue. */
	public void clear(){
		while(!isEmpty()){
			dequeue();
		}
	}

}
