package __Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _01987_알파벳 {
	static int R, C, cnt, ans;
	static char[][] arr;
	static boolean[] charArr;
	static int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];	// 주어진 배열
		charArr = new boolean[26];	// 알파벳 지났는지 확인하는 배열
		cnt = ans = 0;
		
		for (int i = 0; i < R; i++)
			arr[i] = br.readLine().toCharArray();
		charArr[arr[0][0] - 'A'] = true;
		dfs(0, 0);
		System.out.println(ans);
	}
	private static void dfs(int r, int c) {
		cnt++;
		ans = Math.max(ans, cnt);
		
		if(r == R - 1 && c == C - 1) return;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + DIR[i][0];
			int nc = c + DIR[i][1];
			if(nr >= R || nc >= C || nr < 0 || nc < 0) continue;
			if(charArr[arr[nr][nc] - 'A']) continue;	// 이미 지난 문자면 넘어감
			charArr[arr[nr][nc] - 'A'] = true;
			dfs(nr, nc);
			charArr[arr[nr][nc] - 'A'] = false;
			cnt--;
		}
	}
}
