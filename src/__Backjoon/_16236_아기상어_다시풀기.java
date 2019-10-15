package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _16236_아기상어_다시풀기 {
	static int N, r, c, size, count; // count == size 면 size++;
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int map[][];
	static boolean visited[][];
	static PriorityQueue<Fish> fishQ;
	
	static class Fish implements Comparable<Fish>{
		int r, c;
		int size;
		int distance;
		
		public Fish(int r, int c, int size, int distance) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}

		@Override
		public int compareTo(Fish o) {
			int result = distance - o.distance;
			if(result == 0)
				result = r - o.r;
			return result == 0? c - o.c: result;
		}

		@Override
		public String toString() {
			return "[" + r + ", " + c + ", size=" + size + ", distance=" + distance + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fishQ = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) continue;
				else if(map[i][j] == 9) {
					r = i;
					c = j;
					size = 2;
				}
			}
		}
		int time = 0;
		while(true) {
			fishQ.clear();
//			물고기 어딨는지 레이더 탐색
			bfs(r, c);
			if(fishQ.isEmpty()) break;
			
//			목표설정
			Fish nearFish = fishQ.poll();
			
//			이동하기
			time += nearFish.distance;
			map[r][c] = 0;
			r = nearFish.r;
			c = nearFish.c;
			map[r][c] = 9;
			
//			잡아먹기
			count++;
			if(count == size) {
				count = 0;
				size++;
			}
		}
		System.out.println(time);
		
		System.out.println(System.currentTimeMillis() - start);
	}

	private static void bfs(int rr, int cc) {
		visited = new boolean[N][N];
		Queue<int[]> Q = new LinkedList<int[]>();
		Q.offer(new int[] {rr, cc});
		visited[rr][cc] = true;
		int dis = 0;
		while(!Q.isEmpty()) {
			int Qsize = Q.size();
			dis++;
			for (int i = 0; i < Qsize; i++) {
				int[] pop = Q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = pop[0] + DIR[dir][0];
					int nc = pop[1] + DIR[dir][1];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] > size) continue;
					if(map[nr][nc] < size && map[nr][nc] != 0) {
						fishQ.offer(new Fish(nr, nc, map[pop[0]][pop[1]], dis));
					}
					visited[nr][nc] = true;
					Q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}
