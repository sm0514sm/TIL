package ___Essential;

import java.util.Arrays;

public class 이진법_삼진법_문자열_문자_숫자변환 {

	public static void main(String[] args) {
		char[] charArr = {'1', '0', '1', '1'};
		System.out.println(Arrays.toString(charArr));
		
		String str2 = new String(charArr);
		System.out.println(str2);

		int num10 = Integer.valueOf(str2, 2);	// 2진법 문자열을 10진법 숫자로
		System.out.println(num10);
	}
}
