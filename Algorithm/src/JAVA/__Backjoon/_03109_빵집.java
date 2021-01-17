package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _03109_빵집 {
	static boolean[][] visited;
	static int[] DIR = { -1, 0, 1 };
	static int MAX, MIN, R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (temp.charAt(j) == 'x') {
					visited[i][j] = true;
				}
			}
		}
		MAX = 0;
		for (int i = 0; i < R; i++) {
			if (go(i, 0))
				MAX += 1;
		}
		System.out.println(MAX);
	}

	private static boolean go(int r, int c) {
		boolean possible = false;
		visited[r][c] = true;
		
		if (c == C - 1) {
			visited[r][c] = false;
			possible = true;
			return possible;
		}
		
		for (int dir = 0; dir < 3; dir++) {
			int rr = r + DIR[dir];
			int cc = c + 1;
			if (rr >= R || cc >= C || rr < 0 || cc < 0)	continue;
			if (visited[rr][cc])	continue;
			possible = go(rr, cc);
			if(possible) return true;
		}
		
		return possible;
	}
}
