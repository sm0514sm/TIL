package _SW_Expert;
import java.util.Scanner;

public class _8016_홀수피라미드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			long N = sc.nextInt();
			long min = 0, max = 0;
			long minCount = 1, maxCount = 1;
			minCount = (N-1)*(N-1)+1;
			maxCount = N*N;
			System.out.printf("#%d %d %d\n", test_case, (minCount*2-1), (maxCount*2-1));
		}
		sc.close();
	}
}
