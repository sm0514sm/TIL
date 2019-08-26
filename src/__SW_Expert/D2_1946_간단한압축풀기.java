package __SW_Expert;
import java.util.Scanner;

public class D2_1946_간단한압축풀기 {
			//SW_Expert는 Solution
	public static void main(String[] args) {
//		System.setIn(new FileInputStream(".txt"));
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			String answer = "";
			int N = sc.nextInt();
			char[] arr = new char[N];
			int[] count = new int[N];
			for(int i =0; i < N; i++) {
				arr[i] = sc.next().charAt(0);
				count[i] = sc.nextInt();
			}
			int what = 0;
			int count10 = 0;
			while(what != N) {
				while(count[what] != 0) {
					answer += arr[what] + "";
					count[what]--;
					count10++;
					if(count10 == 10) {
						answer += "\n";
						count10 = 0;
					}
				}
				what++;
			}
			
			
			System.out.printf("#%d\n%s\n", test_case, answer);
		}
		sc.close();
	}
}
