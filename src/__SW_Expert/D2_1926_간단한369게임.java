package __SW_Expert;

import java.util.Scanner;

public class D2_1926_간단한369게임 {
	// SW_Expert는 Solution
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 1; i <= N; i ++) {
			String numS = i + "";
			int count = 0;
			for(int j = 0; j < numS.length(); j ++) {
				if(numS.charAt(j) == '3' || numS.charAt(j) == '6' || numS.charAt(j) == '9')
					count++;
			}
			if(count == 0)
				System.out.print(i + " ");
			else {
				for(int j = 0 ; j < count ; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
		
		sc.close();
	}
}
