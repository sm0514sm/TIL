package workshop_0806;

public class SimpleLinkedList {
	private static class Node {
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
	
	private Node head;	// 첫번째 노드의 포인터 역할
	private int size;
	
	/* 맨 앞에 원소 추가 */
	public void addFirstNode(Object data) {
		Node newNode = new Node(data, head);	// head에 저장된 첫번째 노드를 새 노드의 링크로
		head = newNode;	// head에 새 노드 연결
		size++;
	}
	
	/* 마지막 노드 찾기 */
	public Node getLastNode() {
		Node current = head;
		if(head != null)
			while(current.link != null)
				current = current.link;

		return current;
	}
	
	/* 마지막 바로 이전 노드 찾기 */
	private Node getPreviousNode(Node node) {
		if(node == head || size <= 1)	return null;
		
		Node current = head;
		while(current.link != node)
			current = current.link;

		return current;
	}
	
	/* 맨 뒤에 원소 추가 */
	public void addLastNode(Object data) {
		Node lastNode = getLastNode();		// null이거나 마지막 노드
		Node newNode  = new Node(data); 
		size++;
		
		if(lastNode == null)	// 공백 리스트 상황
			head = newNode;
		else
			lastNode.link = newNode;
	}
	
	/* 맨 앞의 원소 삭제 */
	public void deleteFirstNode() {
		if(head == null) throw new RuntimeException("공백리스트여서 삭제가 불가능합니다.");
		Node temp = head;
		head = head.link;
		temp.link = null;
		size--;
	}
	
	/* 맨 뒤의 원소 삭제 */
	public void deleteLastNode() {
		Node lastNode = getLastNode();
		if(lastNode == null) throw new RuntimeException("공백리스트여서 삭제가 불가능합니다.");
		
		Node preNode = getPreviousNode(lastNode);
		if(preNode != null)	// 리스트 크기가 2이상일 때
			preNode.link = null;
		else 				// 리스트 크기가 1개일 때 (0개일 때는 위 예외로 처리함)
			head = null;
		size--;
	}
	
	/* 리스트의 크기 반환 */
	public int getSize() {
		return size;
	}
	
	/* 리스트의 모든 원소 출력 */
	public void print() {
		Node current = head;
		System.out.print("L = (");
		while(current != null) {
			System.out.print(current.data + "\t");
			current = current.link;
		}
		System.out.println(")");
	}
}















