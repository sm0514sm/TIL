package __Backjoon;

import java.util.Scanner;

//Main
public class _03052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		boolean[] arr = new boolean[42];
		for (int i = 0; i < 10; i++) {
			int temp = sc.nextInt();
			if (!arr[temp % 42]) {
				answer++;
				arr[temp % 42] = true;
			}
		}
		System.out.printf("%d\n", answer);
		sc.close();
	}
}
