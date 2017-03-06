package List;

public class ListArray<T> implements ListInterface<T> {

	private final T[] List;
    private int back;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;
    
    /** Creates an empty stack whose initial capacity is 10. */
    public ListArray() {
        this(DEFAULT_CAPACITY);
    } // end default constructor
    
    /**
     * Creates an empty stack having a given initial capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */
    public ListArray(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempList = (T[]) new Object[desiredCapacity]; // Unchecked cast
            List = tempList;
            back = -1;
        }
        else
            throw new IllegalStateException("Attempt to create a Queue " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    } // end constructor
	
	/**
	 * this will add an item to the back of the list
	 * @param newEntry
	 * @return
	 */
	public boolean Add(T newEntry){
		boolean temp = false;
		if(CountEntries() < List.length - 1){
			List[back+1] = newEntry;
			back++;
			temp = true;
		}
		return temp;
	}
	
	/**
	 * this adds an item to a specific place
	 * @param newEntry
	 * @param where
	 * @return
	 */
	public boolean Add(T newEntry, int where){
		boolean temp = false;
		if((where < List.length)&&(back < List.length - 1)){
			for(int i = back + 1; i > where; i--){
				List[i] = List[i-1];
			}
			List[where] = newEntry;
			temp = true;
			back++;
		}
		return temp;
	}
	
	/**
	 * removes an item at position where
	 * @param where
	 * @return
	 */
	public T Remove(int where){
		T temp = List[where];
		List[where] = null;
		back--;
		return temp;
	}
	
	/**
	 * removes and item
	 * @param item
	 * @return
	 */
	public T Remove(T item){
		int where = FindItem(item);
		return Remove(where);
	}
	
	/**
	 * removes all items
	 */
	public void clear(){
		if(!isEmpty()){
			for(int i = 0; i < List.length; i++){
				Remove(i);
			}
		}
	}
	
	/**
	 * replace an item (T replace) with the new entry
	 * @param newEntry
	 * @param replace
	 * @return
	 */
	public T replaceItem(T newEntry, T replace){
		int where = FindItem(replace);
		if(where >= 0){
			T temp = List[where];
			List[where] = newEntry;
			return temp;
		}
		else{
			return null;
		}
	}
	
	/**
	 * replace an item at position (int place) with new entry
	 * @param newEntry
	 * @param place
	 * @return
	 */
	public T replaceItem(T newEntry, int place){
		T temp = List[place];
		List[place] = newEntry;
		return temp;
	}
	
	/**
	 * finds the entry and returns it
	 * @param Entry
	 * @return
	 */
	public T LookAtItem(T Entry){
		int where = FindItem(Entry);
		if(where >= 0){
			return List[where];
		}
		else{
			return null;
		}
	}
	
	/**
	 * returns all the items in the list
	 */
	public void LookAtAll(){
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[List.length];
		for(int i = 0; i < List.length; i++){
			temp[i] = List[i];
		}
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
		int temp = -1;
		for(int i = 0; i < List.length; i++){
			if(List[i] == Entry){
				temp = i;
				break;
			}
		}
		return temp;
	}
	
	/**
	 * returns the number of entries in the list
	 * @return
	 */
	public int CountEntries(){
		return back + 1;
	}
	
	/**
	 * returns weather the list is empty or not
	 * @return
	 */
	public boolean isEmpty(){
		if(back < 0){
			return true;
		}
		else{
			return false;
		}
	}
	
}
