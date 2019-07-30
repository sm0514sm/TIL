package jungol;

import java.util.Scanner;
import java.util.Stack;

public class _1809_탑 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> tempS;
		for (int i = 0; i < N; i++) {
			boolean isPrint = false;
			tempS = (Stack<Integer>) stack.clone();
			int next = sc.nextInt();
			stack.push(next);
			while (tempS.size() != 0) {
				int temp = tempS.pop();
				if (temp > next) {
					System.out.print((tempS.size() + 1) + " ");
					isPrint = true;
					break;
				}
			}
			if (!isPrint)
				System.out.print(0 + " ");

		}

		sc.close();
	}
}
