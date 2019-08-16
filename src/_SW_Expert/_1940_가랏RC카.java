package _SW_Expert;
import java.util.Scanner;

public class _1940_가랏RC카 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;			// 이동거리
			int speed = 0;
			int N = sc.nextInt();
			for(int i = 0; i < N; i ++) {
				int command = sc.nextInt();
				if(command == 1)
					speed += sc.nextInt();
				else if(command == 2) {
					speed -= sc.nextInt();
					if(speed < 0)
						speed = 0;
				}
				answer += speed;
			}
			
			
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}
}
