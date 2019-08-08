package _SW_Expert;

import java.util.Scanner;

public class _1959_두개의숫자열 {
	// SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] Ns = new int[N];
			int[] Ms = new int[M];
			for (int i = 0; i < N; i++)
				Ns[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				Ms[i] = sc.nextInt();
			for (int i = 0; i < Math.abs(M - N) + 1; i++) {
				int Ncount = 0, Mcount = 0, ans = 0;
				if (M > N) {
					while (Mcount < i)
						Mcount++;
					while (Ncount < N) {
						ans += Ms[Mcount++] * Ns[Ncount++];
					}
				} else {
					while (Ncount < i)
						Ncount++;
					while (Mcount < M) {
						ans += Ns[Ncount++] * Ms[Mcount++];
					}
				}
				answer = Math.max(answer, ans);
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
