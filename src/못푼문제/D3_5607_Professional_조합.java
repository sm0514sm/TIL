package 못푼문제;

import java.util.Scanner;

//	페르마의 소정리를 이용해야한다!
public class D3_5607_Professional_조합 {
	// SW_Expert는 Solution

	static long[] factorial = new long[1000001];
	static int P = 1234567891;
	static int N, R;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++)
			factorial[i] = (factorial[i - 1] * i) % P;

		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			N = sc.nextInt();
			R = sc.nextInt();
			System.out.println("#" + test_case + " " + combi());
			
		}
		sc.close();
	}

	private static long combi() {
		return (factorial[N] * power(factorial[N - R], P - 2) % P * power(factorial[R], P - 2) % P) % P;

	}

	private static long power(long a, int b) {
		if (b == 1)
			return a;
		long r = power(a, b / 2);
		r = (r * r) % P;
		
		if (b % 2 > 0)	r = (r * a) % P; // 홀수인 경우 한번 더 곱해준다
		return r % P;
	}
}
