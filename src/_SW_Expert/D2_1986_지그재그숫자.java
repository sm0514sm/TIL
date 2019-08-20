package _SW_Expert;
import java.util.Scanner;

public class D2_1986_지그재그숫자 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int N = sc.nextInt();
			for(int i = 1; i<= N;i++) {
				if(i%2!=0)
					answer+= i;
				else
					answer-= i;
			}
			
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
