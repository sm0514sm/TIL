package __Backjoon;
import java.util.Scanner;

//Main
public class _10872_팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long ans = 1;
		for (int i = 2; i <= N; i++) {
			ans *= (long) i;
		}
		System.out.printf("%f\n", ans);
		sc.close();
	}
}
