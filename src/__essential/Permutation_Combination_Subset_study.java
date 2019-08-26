package __essential;

import java.util.Arrays;

import com.sun.xml.internal.ws.encoding.SwACodec;

public class Permutation_Combination_Subset_study {
	static int[] array = { 1, 2, 3, 4, 5, 6, 7 };
	static int[] numbers;
	static int N, R, num;

	public static void main(String[] args) {
		N = 7;
		array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = i + 1;
		R = 3; // 7P3 or 7C3
		numbers = new int[R];

//		/* Permutation */
//		num = 0;
//		permutation_flag(0, 0);
//		System.out.println(num);
		
		num = 0;
		permutation_swap(0);
		System.out.println(num);
		
		
//		do {
//			System.out.println(Arrays.toString(array));
//		} while (nextPermutation());
		
//
//		/* Combination */
//		for (int i = 0; i < N; i++)
//			array[i] = i + 1;
//		numbers = new int[N];
//		combination_before(-1, 0);
//
//		/* Subset */
//		num = 0;
//		subset_while();
//		System.out.println("num : " + num);
//		
//		num = 0;
//		subset_loop(0, 0);
//		System.out.println("num : " + num);
	}

	private static void permutation_flag(int index, int flag) {
		if(index == R) {
			num++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			numbers[index] = array[i];
			permutation_flag(index + 1, flag | 1 << i); 
		}
	}

	private static void permutation_swap(int index) {
		if(index == R) {
			num++;
			System.out.println(Arrays.toString(Arrays.copyOf(array, R)));
			return;
		}
		for(int i = index; i < N; i++) {
			swap(i, index);
			permutation_swap(index+1);
			swap(i, index);
		}
	}
	
	private static void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private static boolean nextPermutation() {
		return true;
	}

	private static void combination_before(int before, int index) {
	}

	private static void subset_while() {
	}

	private static void subset_loop(int count, int flag) {
	}
}
