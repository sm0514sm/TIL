package workshop;

import java.util.Arrays;
import java.util.Scanner;

public class BabyJin {
	public static boolean run(char[] chs) {
		Arrays.sort(chs);
		if (chs[0] + 1 == chs[1] && chs[0] + 2 == chs[2])
			return true;
		else
			return false;
	}

	public static boolean triple(char[] chs) {
		if (chs[0] == chs[1] && chs[1] == chs[2])
			return true;
		else
			return false;
	}

	public static boolean babyjin(char[] chs, int index, int sub1, int sub2) {
		if (index >= 4 || sub2 >= 6)			return false;
		
		char[] temp = new char[3];				// index, sub1, sub2에 의해 선택된 3개
		char[] temp2 = new char[3];				// 선택되지 못한 나머지 3개
		boolean[] tmpBool = new boolean[6];		// 선택되었는지 판단하기 위해 쓰임
		
		tmpBool[0]    = true;
		tmpBool[sub1] = true;
		tmpBool[sub2] = true;
		int k = 0;
		for (int i = 0; i < tmpBool.length; i++)
			if (!tmpBool[i])
				temp2[k++] = chs[i];
		temp[0] = chs[0];
		temp[1] = chs[sub1];
		temp[2] = chs[sub2];
		
		int sum = 0;
		if (run(temp)  || triple(temp))		sum++;
		if (run(temp2) || triple(temp2))	sum++;
		
		if (sum == 2)
			return true;
		else {
			if (babyjin(chs, index, sub1, sub2 + 1))
				return true;
			else {
				if (babyjin(chs, index, sub1 + 1, sub2 + 1))
					return true;
				else
					return (babyjin(chs, index + 1, sub1 + 1, sub2 + 1));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String card = sc.next();
		char[] chs = card.toCharArray();
		System.out.println(babyjin(chs, 0, 1, 2));

		sc.close();
	}

}
