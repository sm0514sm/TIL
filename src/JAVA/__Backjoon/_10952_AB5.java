package __Backjoon;
import java.util.Scanner;

//Main
public class _10952_AB5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0) break;
			System.out.printf("%d\n", a+b);
		}
		sc.close();
	}
}