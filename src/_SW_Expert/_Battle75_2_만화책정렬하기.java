package _SW_Expert;
import java.util.Scanner;

public class _Battle75_2_만화책정렬하기 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int answer = 0;
			int size = sc.nextInt();
			int[] arr = new int[size];
			for(int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}
			int start = 1;
			while(true) {
				if(start == size +1) break;
				answer++;
				for(int i = 0; i < size; i++) {
					if(start == arr[i]) {
						arr[i] = 0;
						start++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", test_case, answer);
		}
		sc.close();
	}

}
