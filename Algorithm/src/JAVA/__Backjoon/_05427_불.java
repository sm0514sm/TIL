package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _05427_불 {
	static int R, C, r, c;
	static char[][] map;
	static int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static Queue<int[]> fires;
	static Queue<int[]> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			Q = new LinkedList<>();
			fires = new LinkedList<int[]>();
			map = new char[R][C];
			int ans = 0;
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') {
						fires.offer(new int[] {i, j});
					}
					else if(map[i][j] == '@') {
						r = i;
						c = j;
					}
				}
			}

			Q.add(new int[] {r, c});
			for (int time = 1; time <= 10000000; time++) {
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
				System.out.println("IMPOSSIBLE");
			}
			else {
				System.out.println(ans);
			}
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
				if(map[nr][nc] == '#' || map[nr][nc] == '*') continue;
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
				if(nr >= R || nc >= C || nr < 0 || nc < 0)  return true;
				if(map[nr][nc] == '#' || map[nr][nc] == '*' || map[nr][nc] == '@') continue;
				map[nr][nc] = '@';
				Q.offer(new int[] {nr, nc});
			}
		}
		return false;
	}
	
}
