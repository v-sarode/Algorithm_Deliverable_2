import java.util.ArrayList;
import java.util.List;


public class Node<T> {
	
	T ob;
	Node Parent;
	Node Child;
	List<Node<T>> childList = new ArrayList<Node<T>>();
	
	
	public Node(T o){
		this.ob = o;
		Child = null;
		Parent = null;
	}
	
	
	public T getT(){
		return this.ob;
	}
	
	
	public void addChild(Node<T> childNode){
		this.Child = childNode;
	}
	
	
	public void addParent(Node<T> parentNode){
		this.Parent = parentNode;
	}
	
	public void path(){
		
	}
}
