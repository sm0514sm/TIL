package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main
public class _17822_원판돌리기 {
	static int N, M, T, SUM, CNT; // 원판 개수, 수의 개수, 돌리는 횟수
	static ArrayList<Integer>[] lists;
	static int[][] command;
	static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		lists = new ArrayList[N ];
		command = new int[T][3];
		CNT = N*M;

		for (int i = 0; i < N; i++) {
			lists[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				lists[i].add(temp);
				SUM += temp;
			}
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 회전시킬 판
			int d = Integer.parseInt(st.nextToken()); // 방향
			int k = Integer.parseInt(st.nextToken()); // 회전 수

			for (int num = x-1; num < N; num += x) {
				rotate(lists[num], d, k);
			}
			if (!isAdj()) {
				// 인접한 게 없다면
				if(CNT == 0) {
					SUM = 0;
					break;
				}
				makeAvg();
				
			}
		}
		System.out.println(SUM);
	}

	private static void rotate(ArrayList<Integer> list, int d, int k) {
		if(d == 0) {	// 시계 방향
			for (int i = 0; i < k; i++) {
				int temp = list.get(M-1);
				list.remove(M-1);
				list.add(0, temp);
			}
		}
		else {	// 반시계 방향
			for (int i = 0; i < k; i++) {
				int temp = list.get(0);
				list.remove(0);
				list.add(temp);
			}
		}
	}

	static boolean[][] visited;
	static boolean isAdj;
	
	private static boolean isAdj() {
		isAdj = false;
		
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] || lists[i].get(j) == 0) continue;
				dobfs(i, j, lists[i].get(j));
			}
		}
		return isAdj;
	}

	private static void dobfs(int i, int j, int value) {
		Queue<int[]> Q = new LinkedList<>();
		int whileCnt = 0;
		Q.offer(new int[] {i, j});
		while(!Q.isEmpty()) {
			whileCnt++;
			if(whileCnt == 2) {
				isAdj = true;
				lists[i].set(j, 0);
				CNT--;
				SUM -= value;
			}
			int[] pop = Q.poll();
			visited[pop[0]][pop[1]] = true;
			for (int dir = 0; dir < 4; dir++) {
				int nr = pop[0] + DIR[dir][0];
				int nc = pop[1] + DIR[dir][1];
				if(nc == -1) nc = M-1;
				else if(nc == M) nc = 0;
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(visited[nr][nc]) continue;
				if(lists[nr].get(nc) != value) continue;
				Q.offer(new int[] {nr, nc});
				lists[nr].set(nc, 0);
				SUM -= value;
				CNT--;
			}
		}
	}

	private static void makeAvg() {
		double avg = (double) SUM / CNT;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int value = lists[i].get(j);
				if(value == 0) continue;
				if(value > avg) {
					lists[i].set(j, value - 1);
					SUM--;
				}
				else if(value < avg) {
					lists[i].set(j, value + 1);
					SUM++;
				}
			}
		}
	}
}
