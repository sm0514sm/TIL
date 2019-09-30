package __Jungol;
import java.io.IOException;
import java.util.Scanner;

public class _2543_타일채우기 {
	static int N, r, c;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		arr = new int[N][N];
		
		doit(new int[] {r, c}, N);
		
		sc.close();
	}

	private static void doit(int[] target, int size) {
		
	}
}
