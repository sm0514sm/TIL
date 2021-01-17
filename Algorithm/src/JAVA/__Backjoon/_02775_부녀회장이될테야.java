package __Backjoon;
import java.util.Scanner;

//Main
public class _02775_부녀회장이될테야 {
	static int[][] map = new int[15][15];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
//		for (int i = 1; i < 15; i++) {
//			map[0][i] = i;
//		}
		for (int tc = 0; tc < T; tc++) {
			int k = sc.nextInt(); // 층
			int n = sc.nextInt(); // 호
			
			System.out.println(get(k, n));
		}
		sc.close();
	}
	private static int get(int k, int n) {
		if(map[k][n] != 0)
			return map[k][n];
		if(k == 0)
			return n;
		if(n == 1)
			return 1;
		
		return get(k-1, n) + get(k, n-1);
	}
}
