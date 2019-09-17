package _ELSE;

import java.util.Arrays;
import java.util.Scanner;

public class 동전거스름돈구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Coin[] = {1, 4, 6};
		int Memo[] = new int[N+1];
		Arrays.fill(Memo, Integer.MAX_VALUE);
		Memo[0] = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= N; j++) {
				if(j - Coin[i] >= 0)
					Memo[j] = Math.min(Memo[j-Coin[i]] + 1, Memo[j]);
			}
		}
		System.out.println(Memo[N]);
		sc.close();
	}
}
