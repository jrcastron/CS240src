package Queue;

public class DoubleLinkedNode<T> {
	
	 public T data;
	 public DoubleLinkedNode<T> next;
	 public DoubleLinkedNode<T> previouse;

	 public DoubleLinkedNode(DoubleLinkedNode<T> previouse, T data, DoubleLinkedNode<T> next)
	 {
	    this.data = data;
	    this.next = next;
	    this.previouse = previouse;
	 }
	 
	 public T getData(){
		 return data;
	 }
	 
	 public DoubleLinkedNode<T> getNextNode(){
		 return next;
	 }
	 
	 public DoubleLinkedNode<T> getPreviose(){
		 return previouse;
	 }

}
