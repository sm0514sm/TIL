package ___Essential;

public class study {
	static char[] arr = {'A', 'B', 'C', 'D', 'E'};
	static int[] order;
	static int N = 5;
	static int R = 3;
	static int cnt = 0;
	public static void main(String[] args) {
		order = new int[R];
//		permutation(0, 0);
//		System.out.println(cnt);
//		
//		do {
//			System.out.println(Arrays.toString(arr));
//		}while(next_perm());
		
		combination(-1, 0);
	}
	private static void combination(int before, int index) {
		if(index == R) {
			for (int i = 0; i < R; i++)
				System.out.print(arr[order[i]] + " ");
			System.out.println();
			return;
		}
		for (int i = before + 1; i < N; i++) {
			order[index] = i;
			combination(i, index + 1);
		}
	}
	private static boolean next_perm() {
		int i = N - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = N - 1;
		while(arr[i-1] > arr[j]) j--;
		swap(i-1, j);
		
		j = N - 1;
		while(i < j)
			swap(i++, j--);
		
		return true;
	}
	private static void swap(int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	private static void permutation(int index, int flag) {
		if(index == R) {
			for (int i = 0; i < R; i++) 
				System.out.print(arr[order[i]] + " ");
			System.out.println();
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if((flag & (1 << i)) > 0) continue;
			order[index] = i;
			permutation(index + 1, flag | (1 << i));
		}
	}
	
}
