package Dictionary;

public class DictionaryValues<V> {
	
	 public V data;
	 //next actually points to previouse
	 public DictionaryValues<V> next;

	 public DictionaryValues(V data, DictionaryValues<V> next)
	 {
	    this.data = data;
	    this.next = next;
	 }
	 
	 public V getData(){
		 return data;
	 }
	 
	 public DictionaryValues<V> getNextVector(){
		 return next;
	 }

}
