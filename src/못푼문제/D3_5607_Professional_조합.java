package 못푼문제;
import java.util.Scanner;

public class D3_5607_Professional_조합 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			int div = 1234567891;
			long temp = 1;
			for (int i = 1; i <= N; i++) {
				temp *= i;
				temp %= div;
			}
			System.out.println();
		}
		sc.close();
	}
}
