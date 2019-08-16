package _SW_Expert;
import java.util.Scanner;

public class _1976_시각덧셈 {
	public static int setHour(int val) {
		if(val > 12)
			val = val - 12;
		return val;
	}
	public static int setMin(int val) {
		if(val > 59)
			val = val - 60;
		return val;
	}
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int hour1 = sc.nextInt();
			int min1 = sc.nextInt();
			int hour2 = sc.nextInt();
			int min2 = sc.nextInt();
			int hourResult = 0;
			int minResult = setMin(min1+min2);
			if(min1+min2 >= 60)
				hourResult = setHour(hour2+hour1+1);
			else
				hourResult = setHour(hour1+hour2);
			
			System.out.printf("#%d %d %d\n", test_case, hourResult, minResult);
		}
		sc.close();
	}
}
