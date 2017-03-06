package List;

import Stack.Node;

public class LinkedList<T> implements ListInterface<T>{
    private Node<T> front;
    private Node<T> back;
    private int numItems;
	
    public LinkedList(){
    	front = null;
    	back = null;
    	numItems = 0;
    }
    
	/**
	 * this will add an item to the back of the list
	 * @param newEntry
	 * @return
	 */
	public boolean Add(T newEntry){
		if(isEmpty()){
			front = new Node<T>(newEntry, front);
			back = front;
			numItems++;
		}
		else{
			back.next = new Node<T>(newEntry, null);
			back = back.next;
			numItems++;
		}
		return true;
	}
	
	/**
	 * this adds an item to a specific place
	 * @param newEntry
	 * @param where
	 * @return
	 */
	public boolean Add(T newEntry, int where){
		Node<T> temp = getNode(where);
		if(temp!=null){
			Node<T> New = new Node<T>(newEntry, temp.next);
			temp.next = New;
			numItems++;
			return true;
		}
		return false;
	}
	
	/**
	 * find an item and remove it
	 * @param where
	 * @return
	 */
	public T Remove(int where){
		Node<T> temp = getNode(where);
		T removed = null;
		if(temp!=null){
			removed = temp.getData();
			Remove(removed);
		}
		return removed;
	}
	
	/**
	 * removes and item
	 * @param item
	 * @return
	 */
	public T Remove(T item){
		T removed = null;
		Node<T> temp = null;
		if(!isEmpty()){
			if(front.getData() == item){
				removed = item;
				front = front.next;
				numItems--;
			}
			else{
				int i = FindItem(item);
				if(i!=-1){
					temp = getNode(i-1);
					removed = temp.next.getData();
					temp.next = temp.next.next;
					numItems--;
				}
			}
		}
		return removed;
	}
	
	/**
	 * removes all items
	 */
	public void clear(){
		int i = 0;
		while(!isEmpty()){
			Remove(i);
			i++;
		}
	}
	
	/**
	 * replace an item (T replace) with the new entry
	 * @param newEntry
	 * @param replace
	 * @return
	 */
	public T replaceItem(T newEntry, T replace){
		T removed = null;
		if(!isEmpty()){
			int i = FindItem(replace);
			if(i!=-1){
				removed = Remove(replace);
				Add(newEntry, i);
			}
		}
		return removed;
	}
	
	/**
	 * replace an item at position (int place) with new entry
	 * @param newEntry
	 * @param place
	 * @return
	 */
	public T replaceItem(T newEntry, int place){
		T removed = null;
		if(!isEmpty()){
			removed = Remove(place);
			Add(newEntry, place);
		}
		return removed;
	}
	
	/**
	 * finds the entry and returns it
	 * @param Entry
	 * @return
	 */
	public T LookAtItem(T Entry){
		T temp = null;
		if(!isEmpty()){
			int i = FindItem(Entry);
			if(i>=0){
				temp = Entry;
			}
		}
		return temp;
	}
	
	/**
	 * returns all the items in the list
	 */
	public void LookAtAll(){
		int i = CountEntries();
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[i];
		Node<T> temp2 = front;
		for(int j = 0; j < i; j++){
			temp[j] = temp2.getData();
			if(temp2.next!=null){
				temp2 = temp2.next;
			}
		}
		System.out.print("{");
		for(int x = 0; x < i; x++){
			System.out.print(" " + temp[x]);
		}
		System.out.println(" }");
	}
	
	/**
	 * finds the item and returns its position in the list
	 * @param Entry
	 * @return
	 */
	public int FindItem(T Entry){
		int i = 0;
		if(!isEmpty()){
			Node<T> temp = front;
			while((i<CountEntries() - 1)&&(temp.getData()!=Entry)){
				temp = temp.next;
				i++;
			}
			if((temp.getData() == null)||(temp.getData() != Entry)){
				i = -1;
			}
		}
		else{
			i = -1;
		}
		return i;
	}
	
	/**
	 * returns the number of entries in the list
	 * @return
	 */
	public int CountEntries(){
		return numItems;
	}
	
	/**
	 * returns weather the list is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		if(numItems==0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public Node<T> getNode(int place){
		if(!isEmpty()){
			int i = 0;
			Node<T> temp = front;
			while((i<place)&&(i<CountEntries()-1)){
				temp = temp.next;
				i++;
			}
			return temp;
		}
		return null;
	}
	
	public Node<T> getNode(T item){
		if(!isEmpty()){
			Node<T> temp = front;
			while(temp.getData()!=item){
				temp = temp.next;
			}
			return temp;
		}
		return null;
	}

}
