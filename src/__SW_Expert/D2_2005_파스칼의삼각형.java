package __SW_Expert;

import java.util.Scanner;

public class D2_2005_파스칼의삼각형 {
	// SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			System.out.println("#"+test_case);
			int N = sc.nextInt();
			int[][] arr = new int[N][];
			for (int i = 1; i <= N; i++)
				arr[i-1] = new int[i];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if(j == 0 || j == arr[i].length - 1)
						arr[i][j] = 1;
					else
						arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
