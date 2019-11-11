package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _17070_파이프옮기기1 {
	static int N, cnt;
	static int[][] map;
	static int[][] DIR = {{0, 1}, {1, 1}, {1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dodfs(0, 1, 0);
		System.out.println(cnt);
	}
	private static void dodfs(int r, int c, int lastDir) {
		if(r == N-1 && c == N-1) {
			cnt++;
			return;
		}
		for (int i = -1; i <= 1; i++) {
			if(lastDir + i < 0 || lastDir + i >= 3) continue;
			int nr = r + DIR[lastDir + i][0];
			int nc = c + DIR[lastDir + i][1];
			if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
			if(lastDir + i == 1) {
				if(map[nr][nc] == 1 || map[nr-1][nc] == 1 || map[nr][nc-1] == 1) continue;
			}
			else
				if(map[nr][nc] == 1) continue;
			dodfs(nr, nc, lastDir + i);
 		}
	}
}
