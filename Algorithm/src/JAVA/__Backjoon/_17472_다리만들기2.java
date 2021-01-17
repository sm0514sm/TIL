package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _17472_다리만들기2 {
	static int N, M, cnt = 0; // 섬개수
	static int[][] map, adjList;	// 맵과 인접리스트

	static class Vertex implements Comparable<Vertex> {
		int vertex, weight;

		public Vertex(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
//		0. 입력값 처리
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
//		1. 섬 식별 하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					set(i, j, cnt + 2);
					cnt++;
				}
			}
		}
		
//		2. 섬끼리 연결될 수 있는 다리[간선] 찾기
		adjList = new int[cnt + 1][cnt + 1];
		for (int i = 0; i < N; i++) {
			int start = 0, end = 0;
			int len = 0;
			boolean endready = false;
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && start == 0)
					start = map[i][j] - 1;
				else if (map[i][j] == 0 && start != 0) {
					len++;
					endready = true;
				} else if (map[i][j] != 0 && start != 0 && endready) {
					end = map[i][j] - 1;
					if (len >= 2)
						adjList[start][end] = adjList[end][start] = Math.min(len,
								adjList[start][end] == 0 ? Integer.MAX_VALUE : adjList[start][end]);
					start = end;
					len = 0;
					endready = false;
				}
			}
		}
		for (int j = 0; j < M; j++) {
			int start = 0, end = 0;
			int len = 0;
			boolean endready = false;
			for (int i = 0; i < N; i++) {
				if (map[i][j] != 0 && start == 0)
					start = map[i][j] - 1;
				else if (map[i][j] == 0 && start != 0) {
					len++;
					endready = true;
				} else if (map[i][j] != 0 && start != 0 && endready) {
					end = map[i][j] - 1;
					if (len >= 2)
						adjList[start][end] = adjList[end][start] = Math.min(len,
								adjList[start][end] == 0 ? Integer.MAX_VALUE : adjList[start][end]);
					start = end;
					len = 0;
					endready = false;
				}
			}
		}
		
//		
		boolean visited[] = new boolean[cnt + 1];
		int result = 0;
		int num = 0;

		PriorityQueue<Vertex> Q = new PriorityQueue<>();
		Q.add(new Vertex(1, 0));
		while (!Q.isEmpty()) {
			Vertex current = Q.poll();
			if(visited[current.vertex]) continue;
			
			visited[current.vertex] = true;
			result += current.weight;
			if (++num == cnt)
				break;
			for (int i = 1; i <= cnt; i++) {
				if (visited[i] || adjList[current.vertex][i] == 0)
					continue;
				Q.add(new Vertex(i, adjList[current.vertex][i]));
			}
		}
		System.out.println(result == 0 || num != cnt ? -1 : result);
	}

	static int[][] DIR = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static void set(int r, int c, int val) {
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.add(new int[] { r, c });
		while (!Q.isEmpty()) {
			int[] pop = Q.poll();
			map[pop[0]][pop[1]] = val;

			for (int dir = 0; dir < 4; dir++) {
				int nr = pop[0] + DIR[dir][0];
				int nc = pop[1] + DIR[dir][1];
				if (nr >= N || nc >= M || nr < 0 || nc < 0)
					continue;
				if (map[nr][nc] != 1)
					continue;
				Q.add(new int[] { nr, nc });
			}
		}
	}
}
