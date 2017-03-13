package Dictionary;

import java.util.Iterator;

import List.ListVector;

public class LinkedDictionary<K, V> implements DictionaryInterface<K, V>{
	
	private DictionaryKey<K, V> firstKey;
	private DictionaryKey<K, V> lastKey;
	private DictionaryValues<V> value;
	private int numKeys = 0;
	
	public LinkedDictionary(){
		firstKey = null;
		lastKey = firstKey;
		value = null;
	}
	
	/** Adds a new entry to this dictionary. If the given search key already
    exists in the dictionary, replaces the corresponding value.
    @param key    An object search key of the new entry.
    @param value  An object associated with the search key.
    @return  Either null if the new entry was added to the dictionary
             or the value that was associated with key if that value
             was replaced. */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public V add(K key, V v){
		if(isEmpty()){
			value = new DictionaryValues(v, null);
			firstKey = new DictionaryKey(value, key, null);
			lastKey = firstKey;
			numKeys++;
			return firstKey.Vectors().getItem(0).getData();
		}
		else{
			DictionaryKey<K, V> temp = firstKey;
			if(key == temp.getData()){
				int numV = temp.Values.CountEntries() - 1;
				value = new DictionaryValues(v, temp.Values.getItem(numV));
				temp.Values.Add(value);
				return temp.Vectors().getItem(numV + 1).getData();
			}
			while(temp != null){
				if(key == temp.getData()){
					int numV = temp.Values.CountEntries() - 1;
					value = new DictionaryValues(v, temp.Values.getItem(numV));
					temp.Values.Add(value);
					return temp.Vectors().getItem(numV + 1).getData();
				}
				temp = temp.next;
			}
			if(temp == null){
				value = new DictionaryValues(v, null);
				lastKey.next = new DictionaryKey(value, key, null);
				lastKey = lastKey.next;
				numKeys++;
				return v;
			}
		}
		return null;
	}
	
	/** Removes a specific entry from this dictionary.
	    @param key  An object search key of the entry to be removed.
	    @return  Either the value that was associated with the search key
	             or null if no such object exists. */
	public V remove(K key){
		V result = null;
		if(!isEmpty()){
			DictionaryKey<K, V> temp = firstKey;
			if(temp.getData() == key){
				result = firstKey.Vectors().getItem(0).getData();
				if(firstKey.next != null){
					firstKey = firstKey.next;
				}
				else{
					firstKey = null;
				}
			}
			else{
				while(temp.next != null){
					if(temp.next.getData() == key){
						result = temp.next.Vectors().getItem(0).getData();
						temp.next = temp.next.next;
					}
					temp = temp.next;
				}
			}
		}
		numKeys--;
		return result;
	}
	
	/** Retrieves from this dictionary the value associated with a given
	    search key.
	    @param key  An object search key of the entry to be retrieved.
	    @return  Either the value that is associated with the search key
	             or null if no such object exists. */
	public void getValue(K key){
		if(!isEmpty()){
			DictionaryKey<K, V> temp = firstKey;
			if(temp.getData() == key){
				DictionaryValues<V> temp2 = firstKey.Vectors().getItem(firstKey.Vectors().CountEntries() - 1);
				System.out.print("\nvalues: " + temp2.getData());
				while(temp2.next!=null){
					temp2 = temp2.next;
					System.out.print(" " + temp2.getData());
				}
				System.out.println();
			}
			else{
				while(temp.next != null){
					if(temp.next.getData() == key){
						DictionaryValues<V> temp2 = temp.next.Vectors().getItem(temp.next.Vectors().CountEntries() - 1);
						System.out.print("\nvalues: " + temp2.getData());
						while(temp2.next!=null){
							temp2 = temp2.next;
							System.out.print(" " + temp2.getData());
						}
						System.out.println();
					}
					temp = temp.next;
				}
			}
		}
	}
	
	/** Sees whether a specific entry is in this dictionary.
	    @param key  An object search key of the desired entry.
	    @return  True if key is associated with an entry in the dictionary. */
	public boolean contains(K key){
		boolean result = false;
		if(!isEmpty()){
			DictionaryKey<K, V> temp = firstKey;
			if(temp.getData() == key){
				result = true;
			}
			else{
				while(temp.next != null){
					if(temp.next.getData() == key){
						result = true;
					}
					temp = temp.next;
				}
			}
		}
		return result;
	}
	
	/** Creates an iterator that traverses all search keys in this dictionary.
	    @return  An iterator that provides sequential access to the search
	             keys in the dictionary. */
	public Iterator<K> getKeyIterator(){
		return new KeyIterator();
	}
	
	/** Creates an iterator that traverses all values in this dictionary.
	    @return  An iterator that provides sequential access to the values
	             in this dictionary. */
	public Iterator<V> getValueIterator(){
		return new ValueIterator();
	}
	
	/** Sees whether this dictionary is empty.
	    @return  True if the dictionary is empty. */
	public boolean isEmpty(){
		if(numKeys == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	/** Gets the size of this dictionary.
	    @return  The number of entries (key-value pairs) currently
	             in the dictionary. */
	public int getSize(){
		return numKeys;
	}
	
	/** Removes all entries from this dictionary. */
	public void clear(){
		while(!isEmpty()){
			remove(firstKey.getData());
		}
	}
	
	private class KeyIterator implements Iterator<K>{
		private DictionaryKey<K, V> currentKey;
		
		public KeyIterator(){
			currentKey = new DictionaryKey<K, V>(null, null, firstKey);
		}
		
		public boolean hasNext(){
			return (currentKey.next != null );
		}
		
		public K next(){
	        	if(hasNext()){
	        		currentKey = currentKey.getNextKey();
	        		return currentKey.getData();
	        	}
	        	else{
	        		return null;
	        	}
		}
	}
	 
	private class ValueIterator implements Iterator<V>{
		private DictionaryKey<K, V> currentKey;
		private DictionaryValues<V> currentValue;
		
		public ValueIterator(){
			currentKey = firstKey;
			currentValue = new DictionaryValues<V>(null, firstKey.Vectors().getItem(firstKey.Vectors().CountEntries() -1));
		}
		
		public boolean hasNext(){
				if(currentValue.next != null){
					return true;
				}
				else{
					if(currentKey.next != null){
						currentKey = currentKey.next;
						currentValue = new DictionaryValues<V>(null, currentKey.Vectors().getItem(currentKey.Vectors().CountEntries() -1));
						if(currentValue.next != null){
							return true;
						}
					}
				}
				return false;
		}
		
		public V next(){
			V result = null;
        	if(hasNext()){
        		if(currentValue.next!=null){
        			currentValue = currentValue.next;
        			result = currentValue.getData();
        		}
        		else if(currentKey.next != null){
    				currentKey = currentKey.next;
    					if(currentKey.Vectors().getItem(currentKey.Vectors().CountEntries() - 1) != null){
    						currentValue = currentKey.Vectors().getItem(currentKey.Vectors().CountEntries() - 1);
    						result = currentValue.getData();
    					}
    				}
        		}
    		return result;
		}
	}

}
