package __essential;

import java.util.Arrays;

public class Permutation_Combination_Subset {
	static int[] array = { 1, 2, 3, 4, 5, 6, 7 };
	static int[] numbers;
	static int N, R;

	public static void main(String[] args) {
		N = 7;
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

		/* Combination */
		for (int i = 0; i < N; i++)
			array[i] = i + 1;
		numbers = new int[N];
		combination_before(-1, 0);

		/* Subset */
		subset_while();
		subset_loop();
	}

	private static void permutation_flag(int index, int flag) {
		if (index == R) {
			for (int i = 0; i < R; i++)
				System.out.print((flag | 1 << i) != 0 ? numbers[i] + " " : "");
			System.out.println();
			return;
		}
		for (int i = index; i < N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[index] = array[i];
			permutation_flag(index + 1, flag | 1 << i);
		}
	}

	private static void permutation_swap(int index) {
		if (index == R) {
			System.out.println(Arrays.toString(Arrays.copyOf(array, N)));
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
		for(int i = before + 1; i < N; i++) {
			numbers[index] = array[i];
			combination_before(i, index+1);
		}
	}

	private static void subset_while() {
		
	}

	private static void subset_loop() {
		
	}

}
