package __Backjoon;
import java.util.Scanner;

//Main
public class _10950_AB3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			System.out.printf("%d\n", sc.nextInt() + sc.nextInt());
		}
		sc.close();
	}
}
