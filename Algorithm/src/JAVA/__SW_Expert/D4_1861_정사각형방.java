package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_1861_정사각형방 {
	static int[][] arr;
	static int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, MAX, MAXINDEX;
	static POS[] poss;

	static class POS {
		int r, c;

		public POS(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			MAX = 0;
			MAXINDEX = 0;
			N = Integer.parseInt(br.readLine());
			int NN = N * N;
			arr = new int[N][N];
			poss = new POS[NN+1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					poss[arr[i][j]] = new POS(i, j);
				}
			}
			for (int i = 1; i <= NN; i++) {
				dfs(poss[i].r, poss[i].c, 1, i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(MAXINDEX).append(" ").append(MAX).append("\n");
			bw.append(sb.toString());
			bw.flush();
		}
	}

	private static void dfs(int i, int j, int count, int index) {
		for (int dir = 0; dir < 4; dir++) {
			int r = i + DIR[dir][0];
			int c = j + DIR[dir][1];
			if (r < 0 || c < 0 || r >= N || c >= N)
				continue;
			if (arr[r][c] != arr[i][j] + 1)
				continue;
			dfs(r, c, count + 1, index);
		}
		if(MAX < count) {
			MAX = count;
			MAXINDEX = index;
		}
	}
}


