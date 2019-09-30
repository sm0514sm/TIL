package __SW_Expert;
import java.util.Scanner;

public class D3_6692_다솔이의월급상자 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			double answer = 0;
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				answer += sc.nextDouble() * sc.nextInt();
				
			}
			System.out.printf("#%d %f\n", test_case, answer);
		}
		sc.close();
	}
}
