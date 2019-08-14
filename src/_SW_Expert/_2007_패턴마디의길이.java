package _SW_Expert;
import java.util.Scanner;

public class _2007_패턴마디의길이 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			String text = sc.next();
			FIND_LOOP:
			for(int i = 1; i <= 10; i++) {
				String pattern = text.substring(0, i);
				for(int j = i; j+i < 30; j += i) {
					if(!pattern.equals(text.substring(j, j+i))) 
						continue FIND_LOOP;
				}
				answer = i;
				break;
			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
