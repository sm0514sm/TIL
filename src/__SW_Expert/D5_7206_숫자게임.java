package __SW_Expert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class D5_7206_숫자게임 {
	static String Nstring;
	static int cnt;
	static int[] count = new int[10000];

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		for (int test_case = 1, T = sc.nextInt(); test_case <= T; test_case++) {
			cnt = 0;
			Nstring = sc.next();
			doDivide(Nstring, 0);
			
			System.out.printf("#%d %d\n", test_case, cnt);
		}
		sc.close();
	}

	private static void doDivide(String number, int cut) {
		if(number.length() <= 1 || number.equals("0")) {
			cnt = Math.max(cnt, cut);
			return;
		}
		if(number.length() <= 2 && cut + 3 <= cnt) {
			return;
		}
		if(number.length() <= 3 && cut + 9 <= cnt) {
			return;
		}
		if(number.length() <= 4 && cut + 19 <= cnt) {
			return;
		}
		if(number.length() <= 5 && cut + 30 <= cnt) {
			return;
		}
		int templne = number.length()-1;
		int loopCnt = (1 << templne);
		for (int i = 1; i < loopCnt; i++) {
			int startIdx = 0;
			int endIdx = 1;
			ArrayList<Integer> newNum = new ArrayList<>();
			for (int j = 0; j < templne; j++) {
				if((i & 1 << j) == 0) endIdx++;
				else {
					newNum.add(Integer.parseInt(number.substring(startIdx, endIdx)));
					startIdx = endIdx;
					endIdx = startIdx + 1;
				}
			}
			newNum.add(Integer.parseInt(number.substring(startIdx, number.length())));
			int sum = 1;
			for(int j = 0; j < newNum.size(); j++)
				sum *= newNum.get(j);
			doDivide(String.valueOf(sum), cut+1);
		}
		
		return;
	}
}
