/*
 * input 크기가 커서 binary search 안쓰면 터침
 */

package __SW_Expert;
import java.util.Arrays;
import java.util.Scanner;

public class D4_3074_입국심사 {
	static long maxTime;
			//SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (long test_case = 1, T = sc.nextLong(); test_case <= T; test_case++) {
			long answer = 0;
			int N = sc.nextInt();	// 심사원 수
			int M = sc.nextInt();	// 사람 수
			long[] 심사 = new long[(int) N];
			for (int i = 0; i < N; i++) {
				심사[i] = sc.nextLong();
			}
			Arrays.sort(심사);
			maxTime = 심사[N-1] * M;
			answer = maxTime;
			long start = 0;
			long mid = 0;
			
			while(start <= maxTime) {
				mid = (start + maxTime) / 2;
				long checkCnt = 0;
				for (int i = 0; i < N; i++) {
					checkCnt += mid/심사[i];
				}
				if(checkCnt < M) {
					start = mid + 1;
				}
				else {
					if(answer > mid)
						answer = mid;
					maxTime = mid - 1;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}
