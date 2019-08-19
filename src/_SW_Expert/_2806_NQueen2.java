package _SW_Expert;

import java.util.Scanner;

public class _2806_NQueen2 {
	static int[][] box;
	static int total, N, order[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			total = 0;
			N = sc.nextInt();
			order = new int[N];
			for (int i = 0; i < N; i++) {
				order[i] = i;
			}
			box = new int[N][N];
			perm(0);
			System.out.printf("#%d %d\n", test_case, total);
		}
		sc.close();
	}

	private static void perm(int index) {
		if (N == index) {
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++)
					if(order[i] + (j-i) == order[j])
						return;
				for(int j = i -1; j >= 0; j--)
					if(order[i] + (i-j) == order[j])
						return;
			}
			total++;
			return;
		}
		for (int i = index; i < N; i++) {
			swap(index, i);
			perm(index + 1);
			swap(index, i);
		}
	}

	private static void swap(int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}
}
