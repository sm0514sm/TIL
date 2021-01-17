package __SW_Expert;
import java.util.Scanner;

public class D3_3431_준환이의운동관리 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			long answer = 0;
			long L = sc.nextLong();
			long U = sc.nextLong();
			long X = sc.nextLong();
			if(X < L)
				answer = L - X;
			else if(X >= L && X < U)
				answer = 0;
			else
				answer = -1;
			
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
