package __SW_Expert;
import java.util.Scanner;

public class D3_1289_원재의메모리복구하기 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			String txt = sc.next();
			for (int i = txt.length()-2; i >= 0 ; i--) {
				if(txt.charAt(i) != txt.charAt(i+1))
					answer++;
			}
			if(txt.charAt(0) == '1')
				answer++;
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
