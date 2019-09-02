package __SW_Expert;
import java.util.Scanner;

public class D3_1217_거듭제곱 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			sc.nextInt();
			
			int answer = 0;
			int N = sc.nextInt();
			if(N == 1)
				answer = 1;
			else
				answer = (int) Math.pow(N, sc.nextInt());
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
