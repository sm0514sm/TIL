package 못푼문제;

import java.util.Scanner;

//Main
public class _02855_흥미로운순열 {
	static int[][] dp;
	static int N, S;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			dp[i][i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int max = 0;
			int len = 2;
			while (i + len <= N) {
				int sumL = 0;
				int sumR = 0;
				sumL = getdp(i, i + len/2 - 1);
				sumR = getdp(i + len/2, i + len-1);
				if(sumR <= S && sumL <= S)
					max = len;
				
				len += 2;
			}

			System.out.println(max);
		}

		sc.close();
	}

	private static int getdp(int i, int j) {
		if(dp[i][j] != 0)
			return dp[i][j];
		else {
			int temp = getdp(i, j-1) + getdp(j, j);
			dp[i+1][j] = temp - getdp(i, i);
			return dp[i][j] = temp;
		}
	}
}
