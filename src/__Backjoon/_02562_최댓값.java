package __Backjoon;
import java.util.Scanner;

//Main
public class _02562_최댓값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int maxidx = -1;
		for (int i = 0; i < 9; i++) {
			int val = sc.nextInt();
			if(val > max) {
				max = val;
				maxidx = i;
			}
		}
		
		
		
		
		System.out.printf("%d\n%d\n", max, maxidx+1);
		sc.close();
	}
}
