package __Backjoon;
import java.util.Scanner;

//Main
public class _02869_달팽이는올라가고싶다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		long V = C - A;
		long cnt = A- B;
		System.out.println(V/cnt + (V%cnt==0?0:1) + 1);
		
		sc.close();
	}
}
