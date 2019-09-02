package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 모의_2117_홈방범서비스 {
	static int[][] arr;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_2117.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N + 100 + 100][N + 100 + 100];
			for (int i = 0 + 100; i < N + 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0 + 100; j < N + 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int K = findK(N);
			int max = 0;
			for (int k = K; k >= 1; k--) {
				int price = k * k + (k - 1) * (k - 1);
				int needFindCnt = getFindCnt(price, M);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						int hCnt = getHouseCnt(i+100-k+1, j+100, k);
						if(hCnt >= needFindCnt && hCnt > max) {
							max = hCnt;
						}
					}
				}
			}
			bw.write(String.format("#%d %d\n", test_case, max));
			bw.flush();
		}
	}

	private static int getHouseCnt(int r, int c, int k) {
		int cnt = 0;
		int rr = r;
		int cc = c;
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < k; i++) {
				if(arr[rr+i][cc+i] == 1)
					cnt++;
			}
			rr++;
			cc--;
		}
		rr = r + 1;
		cc = c;
		for (int j = 0; j < k-1; j++) {
			for (int i = 0; i < k-1; i++) {
				if(arr[rr+i][cc+i] == 1)
					cnt++;
			}
			rr++;
			cc--;
		}
		return cnt;
	}

	private static int getFindCnt(int price, int M) {
		int a = 1;
		while(a*M < price)
			a++;
		return a;
	}

	private static int findK(int n) {
		int a = 1;
		while (a < n)	a += 2;
		return a;
	}
}
