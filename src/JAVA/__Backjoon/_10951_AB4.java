package __Backjoon;
import java.util.Scanner;

//Main
public class _10951_AB4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.printf("%d\n", a+b);
		}
		sc.close();
	}
}