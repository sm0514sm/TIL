package __Backjoon;
import java.util.Scanner;

//Main
public class _01436_영화감독숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int N = sc.nextInt();
		int cnt = 0;
		int num = 665;
		while(true) {
			if((num + "").contains("666"))
				cnt++;
			if(cnt == N) {
				answer = num;
				break;
			}
			num++;
		}
		System.out.printf("%d\n", answer);
		sc.close();
	}
}
