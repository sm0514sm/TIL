package jungol;

// nPr 가능 + 비트마스킹 이용함


import java.util.Scanner;

public class _1175_주사위던지기2 {

	private static int[] numbers;
	private static int N, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();		// 횟수
		numbers = new int[N];
		M = sc.nextInt();		// 원하는 합
		permutation(0);
		sc.close();
	}// END main

	// index = 몇번째 숫자 선택인지
	private static void permutation(int index) {
		if (index >= N) {
			int sum = 0;
			for(int i = 0; i<N; i++) {
				sum+= numbers[i];
			}
			if(sum == M) {
				for(int i = 0; i<N; i++) {
					System.out.print(numbers[i] + " ");
				}
				System.out.println();
			}
			return;
		}

		// 가능한 선택지에 대해 반복 (1~N까지 시도)
		for (int i = 1; i <= 6; i++) {
				numbers[index] = i;
				permutation(index + 1);
		}
	}

}
