package __SW_Expert;
import java.util.Scanner;

public class D2_1948_날짜계산기 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int M1 = sc.nextInt();
			int D1 = sc.nextInt();
			int M2 = sc.nextInt();
			int D2 = sc.nextInt();
			
			while(M1 != M2) {
				answer += days[M1] - D1 + 1;
				M1++;
				D1 = 1;
			}
			answer += D2 - D1 + 1;
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
