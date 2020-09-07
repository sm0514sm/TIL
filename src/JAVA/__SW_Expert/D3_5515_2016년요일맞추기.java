package __SW_Expert;
import java.util.Scanner;

public class D3_5515_2016년요일맞추기 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int[] arr = new int[13];
			int m = sc.nextInt();
			int d = sc.nextInt();
			arr[0] = 0;
			arr[1] = 31;
			arr[2] = arr[1]+29;
			arr[3] = arr[2]+31;
			arr[4] = arr[3]+30;
			arr[5] = arr[4]+31;
			arr[6] = arr[5]+30;
			arr[7] = arr[6]+31;
			arr[8] = arr[7]+31;
			arr[9] = arr[8]+30;
			arr[10] = arr[9]+31;
			arr[11] = arr[10]+30;
			int date = arr[m-1] + d+3;
			date = date % 7;
			// 11 9 6 4
			
			
			
			System.out.printf("#%d %d\n", test_case, date);
		}
		sc.close();
	}
}
