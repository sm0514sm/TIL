package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Main
public class _06064_카잉달력 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int max = getGCD(M, N);
			int cnt = x;
			
			int xx = x;
			int yy = x % N;
			if(yy == 0) yy = N;
			while(xx != x || yy != y) {
				yy = (yy + M) % N;
				if(yy == 0) yy = N;
				cnt += M;
				if(cnt > (M*N)/max)
					break;
			}
			
			System.out.println(cnt > (M*N)/max?-1:cnt);
		}
	}

	private static int getGCD(int m, int n) {
		while (m % n != 0) {
			int remain = m % n;
			m = n;
			n = remain;
		}
		return n;
	}
}
