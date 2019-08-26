package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _02667_단지번호붙이기 {
	static int[][] MAP;
	static boolean[][] visited;
	static int[][] DIR = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, total;
	static ArrayList<Integer> arr;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		
		arr = new ArrayList<>();
		total = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		MAP = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				MAP[i][j] = temp.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (MAP[i][j] == 0 || visited[i][j]) continue;
				/* 1이고 방문하지 않은 곳 */
				arr.add(0);
				dfs2(i, j);
//				bfs(i, j);
				total++;
			}
		}
		Object[] result = arr.toArray();
		System.out.println(total);
		Arrays.sort(result);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}

	private static void dfs(int row, int col) {
		visited[row][col] = true;
		arr.set(total, arr.get(total) + 1);
		// 인접한 것들에 대해서
		for (int dir = 0; dir < DIR.length; dir++) {
			int nr = row + DIR[dir][0];
			int nc = col + DIR[dir][1];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			// 접근 가능하고 방문안했으면
			if (!visited[nr][nc] && MAP[nr][nc] == 1)
				dfs(nr, nc);
		}
	}

	private static void dfs2(int row, int col) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { row, col });
		arr.set(total, arr.get(total) + 1);
		visited[row][col] = true;
		
		while (stack.size() != 0) {
			int[] temp = stack.pop();
			int R = temp[0];
			int C = temp[1];
			for (int dir = 0; dir < DIR.length; dir++) {
				int nr = R + DIR[dir][0];
				int nc = C + DIR[dir][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				// 접근 가능하고 방문안했으면
				if (!visited[nr][nc] && MAP[nr][nc] == 1) {
					stack.push(new int[] { nr, nc });
					arr.set(total, arr.get(total) + 1);
					visited[nr][nc] = true;
				}
			}
		}
	}
	private static void bfs(int row, int col) {
		Queue<int[]> Q = new LinkedList<>();
		
		Q.offer(new int[] { row, col });
		arr.set(total, arr.get(total) + 1);
		visited[row][col] = true;

		while (Q.size() != 0) {
			int[] temp = Q.poll();
			int R = temp[0];
			int C = temp[1];
			for (int dir = 0; dir < DIR.length; dir++) {
				int nr = R + DIR[dir][0];
				int nc = C + DIR[dir][1];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				// 접근 가능하고 방문안했으면
				if (!visited[nr][nc] && MAP[nr][nc] == 1) {
					Q.offer(new int[] { nr, nc });
					arr.set(total, arr.get(total) + 1);
					visited[nr][nc] = true;
				}
			}
		}
	}
}
