package ___Essential;

import java.util.Arrays;

// Permutation nPr 	= n!/(n-r)!
// Combination nCr 	= n!/((n-r)!r!)
// Subset			= 2^n  

public class _01_순열_조합_부분집합 {
	static char[] array = { 'A', 'B', 'C', 'D', 'E'};
	static char[] array2 = { 'A', 'B', 'C', 'D'};
	static int[] numbers;
	static int N, N2, R, num;

	public static void main(String[] args) {
		N = 5;
		N2 = 4;
		R = 3; // 7P3 or 7C3
		numbers = new int[R];

		/* Permutation */
//		num = 0;
//		permutation_flag(0, 0);
//		System.out.println(num);
//		
		num = 0;
		permutation_swap(0);
		System.out.println(num);
////		
		
//		do {
//			System.out.println(Arrays.toString(array2));
//		} while (nextPermutation());
		
//
//		/* Combination */
//		combination_before(0, 0);
//		System.out.println(num);
//
//		/* Subset */
//		num = 0;
//		subset_while();
//		System.out.println("num : " + num);
	}

	private static void permutation_flag(int index, int flag) {
		if(index == R) {
			for(int i = 0; i<R ; i++) {
				System.out.print(array[numbers[i]] + " ");
			}
			System.out.println();
			num++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) > 0) continue;
			numbers[index] = i;
			permutation_flag(index + 1, flag | 1 << i);
		}
	}

	private static void permutation_swap(int index) {
		if(index == R) {
			System.out.println(Arrays.copyOfRange(array, 0, R));
			num++;
			return;
		}
		for(int i = index; i < N; i++) {
			swap(index, i);
			permutation_swap(index+1);
			swap(index, i);
		}
	}
	
	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = (char) temp;
	}
	
	private static void swap2(int i, int j) {
		int temp = array2[i];
		array2[i] = array2[j];
		array2[j] = (char) temp;
	}

	private static boolean nextPermutation() {
		int i, j;
		i = j = N2 - 1;
		while(i > 0 && array2[i-1] >= array2[i]) i--;
		if(i == 0) return false;
		
		while(array2[i-1] >= array2[j]) j--;
		swap2(i-1, j);
		
		j = N2 - 1;
		while(i < j)
			swap2(i++, j--);
		
		return true;
	}

	private static void combination_before(int before, int index) {
		if(index == R) {
			System.out.println(Arrays.toString(numbers));
			num++;
			return;
		}
		for(int i = before + 1; i <= N; i++) {
			numbers[index] = i;
			combination_before(i, index + 1);
		}
	}
	
	private static void subset_while() {
		int loopCnt = 1 << N;
		for(int i = 0; i < loopCnt; i++) {
			for (int j = 0; j < N; j++) {
				if((i & 1 << j) > 0)
					System.out.print(array[j] + " ");
			}
			num++;
			System.out.println();
		}
	}

}
