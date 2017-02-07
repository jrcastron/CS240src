package Stack;

public class Node<T> {
	
	 public T data;
	 public Node<T> next;

	 public Node(T data, Node<T> next)
	 {
	    this.data = data;
	    this.next = next;
	 }
	 
	 public T getData(){
		 return data;
	 }
	 
	 public Node<T> getNextNode(){
		 return next;
	 }
	
}
