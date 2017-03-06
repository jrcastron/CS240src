package SortedList;

import Stack.Node;

public class SortedListLinked<T extends Comparable<? super T>> implements SortedListInterface<T> {

    private Node<T> front;
    private Node<T> back;
    private int numItems;
	
    public SortedListLinked(){
    	front = null;
    	back = null;
    	numItems = 0;
    }
    
	
	/** Adds a new entry to this sorted list in its proper order.
    The list's size is increased by 1.
    @param newEntry  The object to be added as a new entry. */
	public void add(T Entry){
		Node<T> temp;
		if(!isEmpty()){
			temp = front;
			int i = 0;
			if(Entry.compareTo(temp.getData()) == -1){
				temp = new Node<T>(Entry, front);
				numItems++;
				front = temp;
			}
			else{
				for(i = 0; i < getLength() - 1; i++){
					if(Entry.compareTo(temp.next.getData()) == -1){
						temp.next = new Node<T>(Entry, temp.next);
						numItems++;
						break;
					}
					temp = temp.next;
				}
				if(i == getLength() - 1){
					back.next = new Node<T>(Entry, null);
					back = back.next;
					numItems++;
				}
			}
		}
		else{
			front = new Node<T>(Entry, null);
			back = front;
			numItems++;
		}
	}
	
	/** Removes the first or only occurrence of a specified entry
	    from this sorted list.
	    @param anEntry  The object to be removed.
	    @return  True if anEntry was located and removed; 
	             otherwise returns false. */
	public boolean remove(T item){
		boolean removed = false;
		Node<T> temp = null;
		if(!isEmpty()){
			if(front.getData() == item){
				front = front.next;
				numItems--;
			}
			else{
				int i = getPosition(item);
				if(i >= 0){
					temp = getNode(i-1);
					temp.next = temp.next.next;
					numItems--;
				}
			}
			removed = true;
		}
		return removed;
	}
	
	/** Gets the position of an entry in this sorted list.
	    @param anEntry  The object to be found.
	    @return  The position of the first or only occurrence of anEntry
	             if it occurs in the list; otherwise returns the position
	             where anEntry would occur in the list, but as a negative
	             integer. */
	public int getPosition(T Entry){
		int i = 0;
		if(!isEmpty()){
			Node<T> temp = front;
			while((i<getLength() - 1)&&(temp.getData()!=Entry)){
				temp = temp.next;
				i++;
			}
			if((temp.getData() == null)||(temp.getData() != Entry)){
				temp = front;
				for(int j = 0; j < getLength(); j++){
					if(Entry.compareTo(temp.getData()) == -1){
						i = j * (-1);
						break;
					}
					temp = temp.next;
				}
				if(temp == back){
					i = (getLength() + 1)*(-1);
				}
			}
		}
		else{
			i = 0;
		}
		return i;
	}
	
	// The following methods are described in Segment 12.9 of Chapter 12
	// as part of the ADT list:
	
	public T getEntry(int place){
		if(!isEmpty()){
			int i = 0;
			Node<T> temp = front;
			while((i<place)&&(i<getLength()-1)){
				temp = temp.next;
				i++;
			}
			return temp.getData();
		}
		return null;
	}
	
	public boolean contains(T Entry){
		int i = 0;
		boolean flag = true;
		if(!isEmpty()){
			Node<T> temp = front;
			while((i<getLength() - 1)&&(temp.getData()!=Entry)){
				temp = temp.next;
				i++;
			}
			if((temp.getData() == null)||(temp.getData() != Entry)){
				flag = false;
			}
		}
		else{
			flag = false;
		}
		return flag;
	}
	
	public T remove(int where){
		Node<T> temp = getNode(where);
		T removed = null;
		if(temp!=null){
			removed = temp.getData();
			remove(removed);
		}
		return removed;
	}
	
	public void clear(){
		int i = 0;
		while(!isEmpty()){
			remove(i);
			i++;
		}
	}
	
	public int getLength(){
		return numItems;
	}
	
	public boolean isEmpty(){
		if(numItems==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Couldn't make an array in main to pass to so I print out the array here
	 */
	public void toArray(){
		@SuppressWarnings({"rawtypes", "unchecked" })
		Comparable[] temp = (T[])(new Comparable[getLength()]);
		Node<T> temp2 = front;
		for(int j = 0; j < getLength(); j++){
			temp[j] = temp2.getData();
			if(temp2.next!=null){
				temp2 = temp2.next;
			}
		}
		System.out.print("{ ");
		for(int i = 0; i < getLength(); i++){
			System.out.print(temp[i] + ", ");
		}
		System.out.println("}");
	}
	
	public Node<T> getNode(int place){
		if(!isEmpty()){
			int i = 0;
			Node<T> temp = front;
			while((i<place)&&(i<getLength()-1)){
				temp = temp.next;
				i++;
			}
			return temp;
		}
		return null;
	}
	
}
