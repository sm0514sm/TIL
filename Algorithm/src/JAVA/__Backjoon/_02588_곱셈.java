package __Backjoon;
import java.io.IOException;
import java.util.Scanner;

//Main
public class _02588_곱셈 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String b = sc.next();
		for (int i = 2; i >= 0; i--) {
			System.out.println((b.charAt(i)-'0') * a);
		}
		System.out.println(a*Integer.parseInt(b));
		sc.close();
	}
}
