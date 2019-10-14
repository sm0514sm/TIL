package __SW_Expert;

import java.util.Arrays;
import java.util.Scanner;

public class D5_7206_숫자게임2 {
	static String Nstring;
	static int N, cnt;

	// SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			cnt = 0;
			Nstring = sc.next();
			N = Integer.parseInt(Nstring);
			doDivide(Nstring, 0);

			System.out.printf("#%d %d\n", test_case, cnt);
		}
		sc.close();
	}

	private static int doDivide(String number, int cut) {
		if(number.length() <= 1) {
			cnt = Math.max(cnt, cut);
			return 0;
		}
		int loopCnt = (1 << number.length()-1);
		for (int i = 1; i < loopCnt; i*=2) {
			int startIdx = 0;
			int endIdx = 1;
			int tempCut = cut;
			int[] newNum = new int[5];
			Arrays.fill(newNum, 1);
			for (int j = 0; j < number.length()-1; j++) {
				if((i & 1 << j) == 0) endIdx++;
				else {
					newNum[j] = Integer.parseInt(number.substring(startIdx, endIdx));
					startIdx = endIdx;
					endIdx = startIdx + 1;
					tempCut++;
				}
			}
			newNum[number.length()-1] = Integer.parseInt(number.substring(startIdx, number.length()));
			int sum = 1;
			for(int j = 0; j < 5; j++)
				sum *= newNum[j];
			doDivide(String.valueOf(sum), tempCut);
		}
		
		return 0;
	}
}
