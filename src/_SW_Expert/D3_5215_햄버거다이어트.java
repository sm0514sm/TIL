package _SW_Expert;

import java.util.Scanner;

public class D3_5215_햄버거다이어트 {
	static boolean[] selected;
	static int[] taste;
	static int[] calory;
	static int N, LimitCal;

	public static int subset(int index) {
		if (index == N) {
			int sumCal = 0;
			int sumTaste = 0;
			for (int i = 0; i < N; i++) {
				sumCal   += selected[i] ? calory[i] : 0;
				sumTaste += selected[i] ? taste[i]  : 0;
			}
			if(sumCal <= LimitCal)
				return sumTaste;
			else
				return 0;
		}
		int max = 0;
		selected[index] = true;
		max = Math.max(max, subset(index+1));
		
		selected[index] = false;
		max = Math.max(max, subset(index+1));
		
		return max;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			N = sc.nextInt();
			LimitCal = sc.nextInt();
			taste = new int[N];
			calory = new int[N];
			for(int i = 0; i < N; i ++) {
				taste[i] = sc.nextInt();
				calory[i] = sc.nextInt();
			}
			selected = new boolean[N];
			answer = subset(0);
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
