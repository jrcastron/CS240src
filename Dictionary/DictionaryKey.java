package Dictionary;

import List.ListVector;

public class DictionaryKey<K, V> {
	
	 public K data;
	 public DictionaryKey<K, V> next;
	 public ListVector<DictionaryValues<V>> Values = new ListVector<DictionaryValues<V>>();

	 public DictionaryKey(DictionaryValues<V> value, K data, DictionaryKey<K, V> next)
	 {
	    this.data = data;
	    this.next = next;
	    Values.Add(value);
	 }
	 
	 public K getData(){
		 return data;
	 }
	 
	 public DictionaryKey<K, V> getNextKey(){
		 return next;
	 }
	 
	 public ListVector<DictionaryValues<V>> Vectors(){
		 return Values;
	 }

}
