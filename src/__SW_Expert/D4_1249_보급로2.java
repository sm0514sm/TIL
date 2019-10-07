package __SW_Expert;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1249_보급로2 {
	static int N;
	static int[][] map, dp;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			for (int t = 1; t < N; t++) {
				for (int i = 0; i <= t; i++) {
					for (int j = 0; j <= t; j++) {
						
					}
				}
			}
			for (int i = 1; i < N; i++) {
				dp[0][i] = dp[0][i-1] + map[0][i]; 
				dp[i][0] = dp[i-1][0] + map[i][0]; 
			}
			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					dp[i][j] = map[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
				}
			}
			
			System.out.println("#" + test_case + " " + dp[N-1][N-1]);
		}
	}
}
