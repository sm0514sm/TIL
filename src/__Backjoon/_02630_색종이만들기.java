package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _02630_색종이만들기 {
	static int blueCnt, whiteCnt, N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		if (!isSameColor(0, 0, N, N)) {
			cut(0, 0, N, N, N / 2);
		}
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}

	private static void cut(int r, int c, int rr, int cc, int mid) {
		if(!isSameColor(r, 		 c, 	  rr - mid, cc - mid)) cut(r, 	 	c, 		 rr - mid, cc - mid, mid / 2);
		if(!isSameColor(r, 		 c + mid, rr - mid, cc		)) cut(r, 		c + mid, rr - mid, cc, 		 mid / 2);
		if(!isSameColor(r + mid, c, 	  rr, 		cc - mid)) cut(r + mid, c, 		 rr, 	   cc - mid, mid / 2);
		if(!isSameColor(r + mid, c + mid, rr, 		cc		)) cut(r + mid, c + mid, rr, 	   cc, 		 mid / 2);
	}

	private static boolean isSameColor(int r, int c, int rr, int cc) {
		int base = arr[r][c];
		for (int i = r; i < rr; i++) {
			for (int j = c; j < cc; j++) {
				if(base != arr[i][j])
					return false;
			}
		}
		if(base == 0) 	whiteCnt++;
		else 			blueCnt++;
		return true;
	}
}
