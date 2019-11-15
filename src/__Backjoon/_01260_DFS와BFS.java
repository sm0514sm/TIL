package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _01260_DFS와BFS {
	static int N, M, V;
	static int[][] matrix;
	static boolean[] visited ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken())-1;
		matrix = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1; 
			int b = Integer.parseInt(st.nextToken())-1;
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		visited[V] = true;
		dfs(V);
		System.out.println();
		bfs(V);
		
	}
	private static void dfs(int v) {
		System.out.print(v+1 + " ");
		for (int i = 0; i < N; i++) {
			if(matrix[v][i] == 0 || visited[i] || i == v) continue;
			visited[i] = true;
			dfs(i);
		}
		
	}
	private static void bfs(int v) {
		Queue<Integer> Q = new LinkedList<Integer>();
		boolean visited[] = new boolean[N];
		Q.add(v);
		visited[v] = true;
		while(!Q.isEmpty()) {
			int pop = Q.poll();
			System.out.print(pop+1 + " ");
			for (int i = 0; i < N; i++) {
				if(matrix[pop][i] == 0 || visited[i] || i == pop) continue;
				Q.offer(i);
				visited[i] = true;
			}
		}
	}
}
