package jungol;

import java.util.Scanner;
import java.util.Stack;

public class _1809_탑2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = new int[N];
		boolean[] isPrint = new boolean[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		
		for (int i = 0; i < arr.length; i++) {
			int tempI = i;
			for(int k = 0; k <= tempI; k++) {
				stack.push(arr[k]);
			}
			if (!isPrint[i]) {
				int main = stack.pop();
				int dif = 0;
				while (stack.size() != 0) {
					int temp = stack.pop();
					dif++;
					if (temp > main) {
						System.out.print((i-dif)+1 + " ");
						isPrint[i] = true;
						break;
					}
				}
				if (!isPrint[i]) {
					System.out.print(0 + " ");
					isPrint[i] = true;
				}
				i--;
			}

		}

		sc.close();
	}
}
