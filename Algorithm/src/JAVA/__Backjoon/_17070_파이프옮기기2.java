package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _17070_파이프옮기기2 {
	static int N;
	static int[][] map;
	static long[][][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N][3];	// 0은 우측, 1은 대각선, 2는 아래
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][1][0] = 1; // init
		int nr = 0;
		int nc = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 2; c < N; c++) {
				if(map[r][c] == 1) continue;
//				dp 0 인덱스 구하기
				nr = r;
				nc = c - 1;
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					dp[r][c][0] = dp[nr][nc][0] + dp[nr][nc][1];
				}
//				dp 1 인덱스 구하기
				nr = r - 1;
				nc = c - 1;
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][c] != 1 && map[r][nc] != 1)
						dp[r][c][1] = dp[nr][nc][0] + dp[nr][nc][1] + dp[nr][nc][2];
				}
//				dp 2 인덱스 구하기
				nr = r - 1;
				nc = c;
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					dp[r][c][2] = dp[nr][nc][1] + dp[nr][nc][2];
				}
			}
		}
		
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}
