package __SW_Expert;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1249_보급로 {
	static int N;
	static int[][] map, dp, DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1249.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) {
					map[i][j] = temp.charAt(j) - '0';
				}
			}
			Queue<int[]> Q = new LinkedList<int[]>();
			Q.add(new int[] {0, 0});
			dp[0][0] = map[0][0];
//			dp[0][1] = map[0][1];
//			dp[1][0] = map[1][0];
			while(!Q.isEmpty()) {
				int[] pop = Q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = pop[0] + DIR[i][0];
					int nc = pop[1] + DIR[i][1];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue;
					if(dp[pop[0]][pop[1]] + map[nr][nc] < dp[nr][nc]) {
						dp[nr][nc] = dp[pop[0]][pop[1]] + map[nr][nc];
						Q.add(new int[] {nr, nc});
					}
				}
			}
			
			
			System.out.println("#" + test_case + " " + dp[N-1][N-1]);
		}
	}
}
