package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _01018_체스판다시칠하기 {
	static int N, M;
	static char[][] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int answer = 10000000;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = new char[N][M];
		for (int i = 0; i < N; i++) {
			cnt[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i <= N - 8; i++)
			for (int j = 0; j <= M - 8; j++) 
				answer = Math.min(answer, getCount(i, j));
		
		System.out.println(answer);
	}

	private static int getCount(int r, int c) {
		int count1 = 0;
		int count2 = 0;
		// 왼쪽 위가 W
		for (int i = r; i < r+ 8; i++) {
			for (int j = c; j < c + 8; j++) {
				if ((i + j) % 2 == 0 && cnt[i][j] == 'B')
					count1++;
				else if ((i + j) % 2 == 1 && cnt[i][j] == 'W')
					count1++;
			}
		}
		for (int i = r; i < r+8; i++) {
			for (int j = c; j < c+8; j++) {
				if ((i + j) % 2 == 0 && cnt[i][j] == 'W')
					count2++;
				else if ((i + j) % 2 == 1 && cnt[i][j] == 'B')
					count2++;
			}
		}
		return Math.min(count1, count2);
	}
}
