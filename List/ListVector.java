package List;

import java.util.Vector;

public class ListVector<T> implements ListInterface<T>{
	private final Vector<T> List;
	
	public ListVector(){
		List = new Vector<T>();
	}
	
	/**
	 * this will add an item to the back of the list
	 * @param newEntry
	 * @return
	 */
	public boolean Add(T newEntry){
		return List.add(newEntry);
	}
	
	/**
	 * this adds an item to a specific place
	 * @param newEntry
	 * @param where
	 * @return
	 */
	public boolean Add(T newEntry, int where){
		List.add(where, newEntry);
		return true;
	}
	
	/**
	 * find an item and return it if found
	 * @param where
	 * @return
	 */
	public T Remove(int where){
		T entry = null;
		if(!isEmpty()){
			entry = List.get(where);
			List.remove(where);
		}
		return entry;
	}
	
	/**
	 * removes and item
	 * @param item
	 * @return
	 */
	public T Remove(T item){
		T entry = null;
		boolean test = List.contains(item);
		if(test){
			test = List.remove(item);
			entry = item;
		}
		return entry;
	}
	
	/**
	 * removes all items
	 */
	public void clear(){
		List.clear();
	}
	
	/**
	 * replace an item (T replace) with the new entry
	 * returns entry deleted
	 * @param newEntry
	 * @param replace
	 * @return
	 */
	public T replaceItem(T newEntry, T replace){
		T entry = null;
		boolean test = List.contains(replace);
		if(test){
			int temp = List.indexOf(replace);
			entry = getItem(temp);
			List.remove(replace);
			List.add(temp, newEntry);
		}
		return entry;
	}
	
	/**
	 * replace an item at position (int place) with new entry
	 * returns entry deleted
	 * @param newEntry
	 * @param place
	 * @return
	 */
	public T replaceItem(T newEntry, int place){
		T entry = null;
		entry = getItem(place);
		if(entry != null){
			List.remove(place);
			List.add(place, newEntry);
		}
		return entry;
	}
	
	/**
	 * finds the entry and returns it
	 * @param Entry
	 * @return
	 */
	public T LookAtItem(T Entry){
		T item = null;
		boolean test = List.contains(Entry);
		if(test){
			item = Entry;
		}
		return item;
	}
	
	/**
	 * prints out all the items in the list
	 */
	public void LookAtAll(){
		T[] temp;
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[List.size()]; // Unchecked cast
        temp = tempArray;
		List.copyInto(temp);
		System.out.print("{");
		for(int x = 0; x < temp.length; x++){
			System.out.print(" " + temp[x]);
		}
		System.out.println("}");
	}
	
	/**
	 * finds the item and returns its position in the list
	 * @param Entry
	 * @return
	 */
	public int FindItem(T Entry){
		if(List.contains(Entry)){
			return List.indexOf(Entry);
		}
		else{
			return 0;
		}
	}
	
	/**
	 * returns the number of entries in the list
	 * @return
	 */
	public int CountEntries(){
		return List.size();
	}
	
	/**
	 * returns weather the list is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		return List.isEmpty();
	}
	
	/**
	 * gets a position on the list and returns the item there
	 * @param place
	 * @return
	 */
	public T getItem(int place){
		T entry = null;
		if(!isEmpty()){
			entry = List.get(place);
		}
		return entry;
	}


}
