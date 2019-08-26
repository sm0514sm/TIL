package __SW_Expert;

import java.util.Scanner;

public class D2_1954_달팽이숫자 {
	static int dir;

	// SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] move = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int N = sc.nextInt();
			int count = 1;
			dir = 0;
			int[][] arr = new int[N][N];
			int r = 0, rr, cc;
			int c = 0;
			do {
				arr[r][c] = count++;
				if (count == N * N + 1)
					break;
				rr = r + move[dir][0];
				cc = c + move[dir][1];
				while(rr >= N || rr < 0 || cc >= N || cc < 0 || arr[rr][cc] != 0) {
					dir = (dir + 1) % 4;
					rr = r + move[dir][0];
					cc = c + move[dir][1];
				}
				r = rr;
				c = cc;
			} while (count != N * N + 1);
			System.out.println("#" + test_case);
			for(int i = 0; i < N; i ++) {
				for(int j = 0; j < N; j ++)
					System.out.print(arr[i][j] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
