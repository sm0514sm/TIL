package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _01600_말이되고픈원숭이 {
	static int K;
	static int W, H, min;
	static int[][] map;
	static int[][] DIR = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static int[][] HDIR = {{1, -2}, {1, 2}, {2, -1}, {2, 1},
						  {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		min = Integer.MAX_VALUE;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		BFS();
		System.out.println(min == Integer.MAX_VALUE? -1 : min);
	}
	private static void BFS() {
		Queue<int[]> Q = new LinkedList<int[]>();
		boolean[][][] visited= new boolean[H][W][2];
		Q.add(new int[] {0, 0, 0});	// 순서대로 (R, C, 점프횟수)
		int count = -1;
		while(!Q.isEmpty()) {
			int size = Q.size();
			count++;
			for (int s = 0; s < size; s++) {
				int[] pop = Q.poll();
				if(pop[0] == H-1 && pop[1] == W-1) {
					min = Math.min(min, count);
					continue;
				}
				visited[pop[0]][pop[1]][1] = true;
				for (int dir = 0; dir < 4; dir++) {
					int nr = pop[0] + DIR[dir][0];
					int nc = pop[1] + DIR[dir][1];
					if(nr >= H || nc >= W || nr < 0 || nc < 0) continue;
					if(map[nr][nc] == 1 || visited[nr][nc][0]) continue;
					visited[nr][nc][0] = true;
					Q.offer(new int[] {nr, nc, pop[2]});
				}
				for (int dir = 0; dir < 8 && pop[2] < K ; dir++) {
					int nr = pop[0] + HDIR[dir][0];
					int nc = pop[1] + HDIR[dir][1];
					if(nr >= H || nc >= W || nr < 0 || nc < 0) continue;
					if(map[nr][nc] == 1 || visited[nr][nc][1]) continue;
					Q.offer(new int[] { nr, nc, pop[2] + 1 });
				}
			}
		}
		
	}
}

