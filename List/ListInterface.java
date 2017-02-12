package List;

public interface ListInterface<T> {
	
	/**
	 * this will add an item to the back of the list
	 * @param newEntry
	 * @return
	 */
	public boolean Add(T newEntry);
	
	/**
	 * this adds an item to a specific place
	 * @param newEntry
	 * @param where
	 * @return
	 */
	public boolean Add(T newEntry, int where);
	
	/**
	 * find an item and return it if found
	 * @param where
	 * @return
	 */
	public T Remove(int where);
	
	/**
	 * removes and item
	 * @param item
	 * @return
	 */
	public T Remove(T item);
	
	/**
	 * removes all items
	 */
	public void clear();
	
	/**
	 * replace an item (T replace) with the new entry
	 * @param newEntry
	 * @param replace
	 * @return
	 */
	public T replaceItem(T newEntry, T replace);
	
	/**
	 * replace an item at position (int place) with new entry
	 * @param newEntry
	 * @param place
	 * @return
	 */
	public T replaceItem(T newEntry, int place);
	
	/**
	 * finds the entry and returns it
	 * @param Entry
	 * @return
	 */
	public T LookAtItem(T Entry);
	
	/**
	 * returns all the items in the list
	 */
	public void LookAtAll();
	
	/**
	 * finds the item and returns its position in the list
	 * @param Entry
	 * @return
	 */
	public int FindItem(T Entry);
	
	/**
	 * returns the number of entries in the list
	 * @return
	 */
	public int CountEntries();
	
	/**
	 * returns weather the list is empty or not
	 * @return
	 */
	public boolean isEmpty();
	

}
