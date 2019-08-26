package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node{
	char data;
	Node left;
	Node right;
	
	public Node(char data) {
		this.data = data;
	}
	public Node(char data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class BinaryTree{
	private Node root;
	// 자식이 없으면 숫자여야함
	public void preOrder() {
		preOrder(root);
		System.out.println();
	}
	private void preOrder(Node current) {
		if(current == null) return;
		
		System.out.println(current.data + " ");
		preOrder(current.left);
		preOrder(current.right);
	}
	public void add() {
		
	}
}

public class D4_1233_사칙연산유효성검사 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(".txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = 10; test_case <= T; test_case++) {
			int answer = 1;
			int nodeNum = Integer.parseInt(br.readLine());
			for(int i = 0; i<nodeNum; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				char temp = st.nextToken().charAt(0);
				if(Character.isDigit(temp)) {
					if(st.hasMoreTokens() == true) {
						answer = 0;
						
					}
				}
			}
			
			
			
			
			bw.write(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
