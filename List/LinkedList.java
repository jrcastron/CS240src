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
		Node<T> temp = getNode(where-1);
		T removed = null;
		if(temp!=null){
			removed = temp.next.getData();
			temp.next = temp.next.next;
		}
		return removed;
	}
	
	/**
	 * removes and item
	 * @param item
	 * @return
	 */
	public T Remove(T item){
		Node<T> temp = getNode(item);
		T removed = null;
		if(temp!=null){
			temp = front;
			int i = 0;
			while(temp != item){
				temp = temp.next;
				i++;
			}
			removed = Remove(i);
		}
		return removed;
	}
	
	/**
	 * removes all items
	 */
	public void clear(){
		
	}
	
	/**
	 * replace an item (T replace) with the new entry
	 * @param newEntry
	 * @param replace
	 * @return
	 */
	public T replaceItem(T newEntry, T replace){
		
	}
	
	/**
	 * replace an item at position (int place) with new entry
	 * @param newEntry
	 * @param place
	 * @return
	 */
	public T replaceItem(T newEntry, int place){
		
	}
	
	/**
	 * finds the entry and returns it
	 * @param Entry
	 * @return
	 */
	public T LookAtItem(T Entry){
		
	}
	
	/**
	 * returns all the items in the list
	 */
	public void LookAtAll(){
		
	}
	
	/**
	 * finds the item and returns its position in the list
	 * @param Entry
	 * @return
	 */
	public int FindItem(T Entry){
		
	}
	
	/**
	 * returns the number of entries in the list
	 * @return
	 */
	public int CountEntries(){
		
	}
	
	/**
	 * returns weather the list is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		
	}
	
	public Node<T> getNode(int place){
		if(!isEmpty()){
			int i = 0;
			Node<T> temp = front;
			while(i<place){
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
