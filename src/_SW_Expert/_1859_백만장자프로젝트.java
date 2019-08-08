package _SW_Expert;
import java.util.Scanner;

public class _1859_백만장자프로젝트 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int N = sc.nextInt();
			int[] price = new int[N];
			for (int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
