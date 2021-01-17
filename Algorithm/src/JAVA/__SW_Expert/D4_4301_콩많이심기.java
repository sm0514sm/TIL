package __SW_Expert;
import java.util.Scanner;

public class D4_4301_콩많이심기 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][M];
			int cnt = 0;
			int[][] DIR = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(arr[i][j] == 0) {
						cnt++;
						arr[i][j] = 3;	// 콩두기
						for (int k = 0; k < 4; k++) {
							int nr = i + DIR[k][0];
							int nc = j + DIR[k][1];
							if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;
							if(arr[nr][nc] == 0)
								arr[nr][nc] = -1;
						}
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, cnt);
		}
		sc.close();
	}
}
