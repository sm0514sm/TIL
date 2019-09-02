package __Jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1828_냉장고 {
	static int[] tm;
	static int max, min;

	static class C implements Comparable<C> {
		int x, y;

		public C(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(C o) {
			int answer = -(this.y - o.y);
			if (answer == 0)
				answer = (this.x - o.x);
			return answer;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int cnt = 1;
		C[] cs = new C[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			cs[i] = new C(x, y);
		}
		Arrays.sort(cs);
		
		int low = cs[0].x;
		
		for(int i = 1; i < N; i++) {
			if(cs[i].y < low) {
				cnt++;
				low = cs[i].x;
			}
			else {
				if(low < cs[i].x)
					low = cs[i].x;
			}
		}
		System.out.println(cnt);
	}
}
