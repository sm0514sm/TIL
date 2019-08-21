package workshop_0820;

//275p
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HW1_친구관계_이상민 {

	static class Node {
		char value;
		Node link;

		public Node(char value, Node link) {
			this.value = value;
			this.link = link;
		}

		public Node(char value) {
			this.value = value;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[").append(value).append(" ").append(link).append("]");
			return builder.toString();
		}
	}

	static Node[] adjList;
	static boolean[] visited;
	static int count, max;
	static boolean finded;
	static char lastChar;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rsc/graph_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int edgeCnt = sc.nextInt();
		adjList = new Node[N];
		visited = new boolean[N];

		for (int i = 0; i < edgeCnt; i++) {
			char first = sc.next().charAt(0);
			char second = sc.next().charAt(0);

			adjList[first  - 'A'] = new Node(second, adjList[first - 'A']);
			adjList[second - 'A'] = new Node(first, adjList[second - 'A']);
		}
		count = 0;
		max = 0;
		dfs('A' - 'A');
		System.out.println("\nworkshop 개수 : " + max);
		
		visited = new boolean[N];
		lastChar = ' ';
		bfs(0);
		System.out.println("\nhomework 젤 늦는애 : " + lastChar);
		sc.close();
	}

	private static void dfs(int current) {
		visited[current] = true;
		System.out.print((char)(current + 'A') + " ");
		count++;
		Node temp = adjList[current];
		while(temp != null) {
			if(current == 0) count = 1;
			if(!visited[temp.value-'A']) {
				dfs(temp.value - 'A');
			}
			temp = temp.link;
		}
		max = Math.max(max, count);
	}

	private static void bfs(int current) {
		visited[current] = true;
		Queue<Node> Q = new LinkedList<Node>();
		Q.offer(adjList[current]);
		System.out.print((char)(current + 'A') + " ");
		while(!Q.isEmpty()) {
			Node temp = Q.poll();
			
			while(temp != null) {	// 해당 노드가 갈 수 있는 모든 노드들 Q에 넣기
				if(!visited[temp.value - 'A']) {
					visited[temp.value - 'A'] = true;
					Q.offer(adjList[temp.value - 'A']);
					lastChar = temp.value;
					System.out.print(lastChar + " ");
				}
				temp = temp.link;
			}
		}
	}
}
