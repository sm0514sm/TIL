package _SW_Expert;
import java.util.Scanner;

public class _1285_아름이의돌던지기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer = 0;
			int answer2 = 0;
			int min = 100000;
			int[] range = new int[100000];
			for(int i = 0; i < N; i++) {
				range[Math.abs(sc.nextInt())]++;
			}
			for(int i = 0; i < range.length; i++) {
				if(range[i] != 0) {
					if(min > i) {
						min = i;
						answer2 = range[i];
					}
				}
			}
			answer = min;
			System.out.printf("#%d %d %d\n", test_case, answer, answer2);
		}
		sc.close();
	}

}
