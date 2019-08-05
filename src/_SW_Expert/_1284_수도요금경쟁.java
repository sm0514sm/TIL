package _SW_Expert;
import java.util.Scanner;

public class _1284_수도요금경쟁 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			int A_corp;
			int B_corp;
			
			A_corp = P * W;
			if(W > R) {
				B_corp = Q + (W-R)*S;
			}
			else
				B_corp = Q;
			System.out.printf("#%d %d\n", test_case, Math.min(A_corp, B_corp));
		}
		sc.close();
	}

}
