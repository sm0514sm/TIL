package ___Essential;

import java.util.LinkedList;
import java.util.Queue;

public class _02_DFS_BFS {
	static int[][] map = {{0, 1, 0, 0, 0, 0, 0},
						  {1, 0, 0, 1, 0, 0, 0},
						  {0, 0, 0, 0, 1, 0, 0},
						  {0, 1, 0, 0, 0, 1, 0},
						  {0, 0, 1, 0, 0, 1, 0},
						  {0, 0, 0, 1, 1, 0, 1},
						  {0, 0, 0, 0, 0, 1, 0}};
	static boolean[] visited = new boolean[7];
	public static void main(String[] args) {
		System.out.println("*----- DFS -----*");
		dfs(0);
		visited = new boolean[7];
		System.out.println("\n*----- BFS -----*");
		bfs(0);
	}


	private static void dfs(int v) {
		visited[v] = true;
		System.out.print((char) (v + 'A') + " -> ");
		
		for (int i = 0; i < map.length; i++) {
			if(map[v][i] == 0 || visited[i]) continue;
			dfs(i);
		}
	}

	private static void bfs(int v) {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(v);
		visited[v] = true;
		while (!Q.isEmpty()) {
			int pop = Q.poll();
			visited[pop] = true;
			System.out.print((char) (pop + 'A') + " -> ");
			for (int i = 0; i < map.length; i++) {
				if (map[pop][i] == 0 || visited[i]) continue;
				Q.add(i);
			}
		}
	}
}
