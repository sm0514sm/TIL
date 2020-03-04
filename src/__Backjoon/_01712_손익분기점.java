package __Backjoon;
import java.util.Scanner;

//Main
public class _01712_손익분기점 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		if(B >= C) {
			
			System.out.println(-1);
		}
		else {
			int cnt = 1;
			while(A + cnt*B >= C*cnt)
				cnt++;
			System.out.println(cnt);
		}
		
		
		sc.close();
	}
}
