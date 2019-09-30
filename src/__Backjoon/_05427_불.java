package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _05427_불 {
	
	static int[][] DIR = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
	static char[][] map;
	static int w, h, min;
	static ArrayList<FIRE> fireList;
	
	public static class FIRE{
		int r, c;
		boolean did;
		

		public FIRE(int r, int c) {
			this.r = r;
			this.c = c;
		}
		 
		public void doFire() {
			for (int i = 0; i < 4; i++) {
				int nr = r + DIR[i][0];
				int nc = c + DIR[i][1];
				if(nr >= h || nc >= w || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == '.') {
					map[nr][nc] = '*';
					fireList.add(new FIRE(nr, nc));
				}
			}
			did = true;
		}
		
		public void delete() {
			if(did)
				fireList.remove(this);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			map = new char[h][w];
			fireList = new ArrayList<>();
			int r = 0, c = 0;
			for (int i = 0; i < h; i++) {
				String temp = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = temp.charAt(j);
					if(map[i][j]== '@') {
						r = i;
						c = j;
					}else if(map[i][j] == '*') {
						fireList.add(new FIRE(i, j));
					}
				}
			}
			dobfs(r, c);
			if(min == -1) {
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println(min);
			}
		}
	}

	private static void dobfs(int r, int c) {
		Queue<int[]> Q = new LinkedList<>();
		Q.offer(new int[] {r, c});
		int count = 0;
		boolean posible = false;
		Q_LOOP:
		while(!Q.isEmpty()) {
			count++;
			if(count != 1) {
				int fireSize = fireList.size();
				for (int i = 0; i < fireSize; i++) {
					fireList.get(i).doFire();
				}
				for (int i = 0; i < fireList.size(); i++) {
					fireList.get(i).delete();
				}
			}
			int size = Q.size();
			for (int ii = 0; ii < size; ii++) {
				int[] pop = Q.poll();
				if(map[pop[0]][pop[1]] == '*')
					continue;
				map[pop[0]][pop[1]] = '@';
				if (pop[0] == 0 || pop[1] == 0 || pop[0] == h - 1 || pop[1] == w - 1) {
					posible = true;
					break Q_LOOP;
				}
				for (int i = 0; i < 4; i++) {
					int nr = pop[0] + DIR[i][0];
					int nc = pop[1] + DIR[i][1];
					if(nr >= h || nc >= w || nr < 0 || nc < 0) continue;
					if(map[nr][nc] != '.') continue;
					Q.offer(new int[] {nr, nc});
				}
			}
			
		}
		min = Math.min(count, min);
		if(!posible) min = -1;
	}
}
