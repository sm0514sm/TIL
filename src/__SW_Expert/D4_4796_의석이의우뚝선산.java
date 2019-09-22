package __SW_Expert;

import java.util.Scanner;
import java.util.Stack;

public class D4_4796_의석이의우뚝선산 {
	public static void main(String[] args) {
		// System.setIn(new FileInputStream("input-7.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int result = 0;
			long[] arr = new long[N];
			boolean isUp = false; // 산의 높이가 올라가는 경우 true
			int upStart = 0, downEnd = 0, k = 0; // index

			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			for (int i = 0; i < N - 1; i++) {
				if (arr[i] < arr[i + 1]) {
					if (!isUp) {
						downEnd = i;
						if (upStart != downEnd) {
							result += (k - upStart) * (downEnd - k);
						}
						isUp = true;
						upStart = i;
					}
				} else {
					if (isUp) {
						k = i;
						isUp = false;
					}
				}
			}
			if (!isUp) { // 마지막이 내려가는 도중이라면
				result += (k - upStart) * (N - 1 - k);
			}
			System.out.println("#" + t + " " + result);
		}

	}

}