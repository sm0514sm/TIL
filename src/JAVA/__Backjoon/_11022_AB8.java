package __Backjoon;
import java.util.Scanner;

//Main
public class _11022_AB8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("Case #%d: %d + %d = %d\n", i+1, a, b, a+b);
		}
		sc.close();
	}
}

