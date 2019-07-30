package jungol;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class _1809_탑3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] top = new int[N];
		int[] answer = new int[N];
		int index = 0;
		
		for (int i = 0; i < N; i++) {
			top[i] = sc.nextInt();
			for (int j = i-1; j >= 0; j--) {
				if(top[j] > top[i]) {
					answer[i] = j+1;
					break;
				}
				else {
					if(top[answer[j]] > top[i]) {
						answer[i] = answer[j];
						break;
					}
					else {
						j = answer[j];
					}
				}
			}
			System.out.print(answer[i] + " ");
		}
		sc.close();
	}
}
