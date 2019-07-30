package jungol;

import java.util.Scanner;
import java.util.Stack;

public class _1809_탑3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			boolean isPrint = false;
			int next = sc.nextInt();
			int dif = 1;
			while (stack.size() - dif >= 0) {
				int temp = stack.get(stack.size() - dif);
				if(temp > next) {
					isPrint = true;
					System.out.print((i-dif+1) + " ");
					break;
				}
				dif++;
			}
			if(!isPrint)
				System.out.print(0 + " ");
			stack.push(next);
		}

		sc.close();
	}
}
