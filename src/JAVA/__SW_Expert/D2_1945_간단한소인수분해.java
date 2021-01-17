package __SW_Expert;

import java.util.Scanner;

public class D2_1945_간단한소인수분해 {
	//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] abcde = new int[5];
			abcde[0] = divide(N, 2);
			abcde[1] = divide(N, 3);
			abcde[2] = divide(N, 5);
			abcde[3] = divide(N, 7);
			abcde[4] = divide(N, 11);
			
			
			
			System.out.printf("#%d ", test_case);
			for(int i = 0; i < 5; i++)
				System.out.print(abcde[i] + " ");
			System.out.println();
		}
		sc.close();
	}

	private static int divide(int n, int i) {
		int count = 0;
		while(n % i == 0) {
			count++;
			n = n / i;
		}
		return count;
	}
}
