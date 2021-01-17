package __Backjoon;
import java.util.Scanner;

//Main
public class _02884_알람시계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		if(M >= 45)
			M -= 45;
		else {
			M += 15;
			if(H == 0)
				H = 24;
			H -= 1;
		}
		System.out.printf("%d %d\n", H, M);
		sc.close();
	}
}
