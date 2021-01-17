package __SW_Expert;
import java.util.Scanner;

public class D2_1989_초심자의회문검사 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 1;
			String temp = sc.next();
			for(int i = 0; i < temp.length()/2; i++) {
				if(temp.charAt(i) != temp.charAt(temp.length()-i-1))
					answer = 0;
			}
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
