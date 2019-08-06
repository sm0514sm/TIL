package workshop_0806;

public class StackTest {
	public static void main(String[] args) {
		StackLinkedList stack = new StackLinkedList();
//		System.out.println(stack.pop());
		stack.push("월요일");
		stack.push("화요일");
		stack.push("수요일");
		stack.push("목요일");
		stack.push("금요일");
		stack.push("금요일");

		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
