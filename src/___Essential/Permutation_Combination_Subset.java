package ___Essential;

import java.util.Arrays;

public class Permutation_Combination_Subset {
	static int[] array;
	static int[] numbers;
	static int N, R, num;

	public static void main(String[] args) {
		N = 5;
		array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = i + 1;
		R = 3; // 7P3 or 7C3
		numbers = new int[R];

//		/* Permutation */
//		permutation_flag(0, 0);
//		permutation_swap(0);
//		do {
//			System.out.println(Arrays.toString(array));
//		} while (nextPermutation());

//		/* Combination */
//		for (int i = 0; i < N; i++)
//			array[i] = i + 1;
//		numbers = new int[N];
//		combination_before(-1, 0);
//
		/* Subset */
		num = 0;
		subset_while();
		System.out.println("num : " + num);
		
//		num = 0;
//		subset_loop(0, 0);
//		System.out.println("num : " + num);
	}

	private static void permutation_flag(int index, int flag) {
		if (index == R) {
			for (int i = 0; i < R; i++)
				System.out.print((flag | 1 << i) != 0 ? numbers[i] + " " : "");
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[index] = array[i];
			permutation_flag(index + 1, flag | 1 << i);
		}
	}

	private static void permutation_swap(int index) {
		if (index == R) {
			System.out.println(Arrays.toString(Arrays.copyOf(array, R)));
			return;
		}
		for (int i = index; i < N; i++) {
			swap(i, index);
			permutation_swap(index + 1);
			swap(i, index);
		}
	}

	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static boolean nextPermutation() {
		int i = N-1;
		while(i > 0 && array[i-1] >= array[i]) i--;
		if(i == 0) return false;
		
		int j = N-1;
		while(array[i-1] >= array[j]) j--;
		swap(i-1, j);
		
		j = N-1;
		while(i < j) swap(i++, j--);
		return true;
	}

	private static void combination_before(int before, int index) {
		if(index == R) {
			System.out.println(Arrays.toString(Arrays.copyOf(numbers, R)));
			return;
		}
		for(int i = before; i < N; i++) {
			numbers[index] = array[i];
			combination_before(i + 1, index+1);
		}
	}

	private static void subset_while() {
		int loopCnt = 1 << N;
		for(int i = 0; i < loopCnt; i++) {
			for(int j = 0; j < N; j++) {
				if((i & 1 << j) == 0) continue;
				System.out.print(array[j] + " ");
			}
			System.out.println();
			num++;
		}
	}

	private static void subset_loop(int count, int flag) {
		if(count == N) {
			for(int i = 0; i < N ; i++) {
				if((flag & 1 << i) == 0) continue;
				System.out.print(array[i] + " ");
			}
			System.out.println();
			num++;
			return;
		}
		subset_loop(count + 1, flag | 1 << count);
		subset_loop(count + 1, flag);
	}
}
