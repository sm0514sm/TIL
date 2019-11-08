package __Jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _1082_화염에서탈출2 {
	static int R, C, HomeR, HomeC, r, c;
	static char[][] map;
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<int[]> fires;
	static Queue<int[]> Q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = new LinkedList<>();
		fires = new LinkedList<int[]>();
		map = new char[R][C];
		int ans = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					boolean possible = false;
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + DIR[dir][0];
						int nc = j + DIR[dir][1];
						if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
						if(map[nr][nc] == '.') {
							possible = true;
							break;
						}
					}
					if(possible)
						fires.offer(new int[] {i, j});
				}
				else if(map[i][j] == 'D') {
					HomeR = i;
					HomeC = j;
				}
				else if(map[i][j] == 'S') {
					r = i;
					c = j;
				}
			}
		}
		Q.add(new int[] {r, c});
		for (int time = 1; time <= 10000; time++) {
//			사람 이동
			if(doBfs()) {
				ans = time;
				break;
			}
			if(Q.size() == 0) break;
			
//			불 번짐
			doFire();
		}
		if(ans == 0) {
			System.out.println("impossible");
		}
		else {
			System.out.println(ans);
		}
	}

	private static void doFire() {
		int size = fires.size();
		if(size == 0) return;
		
		for (int i = 0; i < size; i++) {
			int[] pos = fires.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = pos[0] + DIR[dir][0];
				int nc = pos[1] + DIR[dir][1];
				if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == 'X' || map[nr][nc] == '*' || map[nr][nc] == 'D') continue;
				if(map[nr][nc] == 'S') Q.remove(new int[] {nr, nc});
				map[nr][nc] = '*';
				fires.offer(new int[] {nr, nc});
			}
		}
	}

	private static boolean doBfs() {
		int size = Q.size();
		if(size == 0) return false;
		
		for (int i = 0; i < size; i++) {
			int[] pos = Q.poll();
			if(map[pos[0]][pos[1]] == '*') continue;
			for (int dir = 0; dir < 4; dir++) {
				int nr = pos[0] + DIR[dir][0];
				int nc = pos[1] + DIR[dir][1];
				if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == 'X' || map[nr][nc] == '*' || map[nr][nc] == 'S') continue;
				if(map[nr][nc] == 'D') return true;
				map[nr][nc] = 'S';
				Q.offer(new int[] {nr, nc});
			}
		}
		return false;
	}
	
}
