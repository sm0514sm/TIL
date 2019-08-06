package workshop_0806;

public class StackLinkedList {
	class Node{
		Object data;
		Node link;
		
		public Node() {
		}

		public Node(Object data) {
			this.data = data;
		}

		public Node(Object data, Node link) {
			this(data);
			this.link = link;
		}
	}
	private Node top;	// 첫번째 노드의 포인터 역할
	private int size;
	
	public boolean isEmpty() {
		return top == null ? true : false;
	}
	
	/* 첫번째 노드로 삽입(푸시) */
	public void push(Object element) {
		Node newNode = new Node(element);
		if(isEmpty())
			top = newNode;
		else {
			newNode.link = top;
			top = newNode;
		}
		size++;
	}
	
	/* 첫번째 노드 확인 */
	public Object peek() {
		if(isEmpty())	throw new RuntimeException("스택이 비었습니다.");
		
		return top.data;
	}
	
	/* 첫번째 노드 팝*/
	public Object pop() {
		if(isEmpty())	throw new RuntimeException("스택이 비었습니다.");
		
		Node temp = top;
		top = top.link;
		temp.link = null;
		size--;
		return temp.data;
	}
	
	public int size() {
		return size;
	}
}
