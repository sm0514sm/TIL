package __Jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _1082_화염에서탈출 {
	static int R, C, HomeR, HomeC, r, c;
	static char[][] map;
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayList<Fire> fires;
	static Queue<int[]> Q;
	
	static class Fire{
		int r, c;

		public Fire(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public void doFire() {
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + DIR[dir][0];
				int nc = c + DIR[dir][1];
				if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
				if(map[nr][nc] == 'D' || map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
				map[nr][nc] = '*';
				fires.add(new Fire(nr, nc));
			}
			fires.remove(this);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Q = new LinkedList<>();
		fires = new ArrayList<>();
		map = new char[R][C];
		int ans = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*')
					fires.add(new Fire(i, j));
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
		for (int time = 1; time <= 100; time++) {
//			사람 이동
			if(doBfs()) {
				ans = time;
				break;
			}
//				집 도착 확인
			
//			불 번짐
			int size = fires.size();
			for (int i = 0; i < size; i++) {
				Fire fire = fires.get(0);
				fire.doFire();
			}
			
		}
		if(ans == 0) {
			System.out.println("impossible");
		}
		else {
			System.out.println(ans);
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
				if(map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
				if(map[nr][nc] == 'D') return true;
				map[nr][nc] = 'S';
				Q.offer(new int[] {nr, nc});
			}
		}
		return false;
	}
	
}
