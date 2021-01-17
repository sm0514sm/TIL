package __SW_Expert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모의_1953_탈주범검거 {
	static int[][] possible = {{1, 2, 4, 7}, 
							   {1, 2, 5, 6}, 
							   {1, 3, 6, 7},
							   {1, 3, 4, 5}};
	
	static int N, M, R, C, L;	// 세로, 가로, 맨홀 R, 맨홀 C, 소요시간
	static int cnt;
	static int[][] map;
	static int[][] DIR = {{-1, 0}, {1, 0}, {0 , -1}, {0, 1}};
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			System.out.println("#" + test_case + " " + cnt);
		}
	}
	private static void bfs() {
		Queue<int[]> Q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		Q.offer(new int[] {R, C});
		cnt++;
		visited[R][C] = true;
		for (int time = 1; time < L && !Q.isEmpty(); time++) {
			int size = Q.size();
			for (int count = 0; count < size; count++) {
				int[] pop = Q.poll();
				for (int dir = 0; dir < 4; dir++) {
					if(!isPossible(pop[0], pop[1], dir)) continue;
					int nr = pop[0] + DIR[dir][0];
					int nc = pop[1] + DIR[dir][1];
					if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
					if(visited[nr][nc]) continue;
					if(!isPossible(nr, nc, dir % 2 == 0? dir+1:dir-1)) continue;
					Q.offer(new int[] {nr, nc});
					visited[nr][nc] = true;
					cnt++;
				} 
			}
		}
	}
	private static boolean isPossible(int i, int j, int dir) {
		int[] list = possible[dir];
		for (int k = 0; k < 4; k++) {
			if(map[i][j] == list[k])
				return true;
		}
		return false;
	}
}
