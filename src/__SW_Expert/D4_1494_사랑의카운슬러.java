package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1494_사랑의카운슬러 {
	static boolean[] selected;
	static int N;
	static int[] order;
	static long MIN;
	static WORM[] worms;
	static class WORM{
		long x, y;

		public WORM(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1494.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			MIN = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			worms = new WORM[N];
			order = new int[N/2];
			selected = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				worms[i] = new WORM(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			combi(0, 0);
			bw.append("#" + test_case + " " + MIN + " \n");
			bw.flush();
		}
	}

	public static void combi(int before, int index) {
		if(index == N/2) {
			for (int i = 0; i < N/2; i++)
				selected[order[i]] = true;
			
			int x, y;
			x = 0;	y = 0;
			for (int i = 0; i < N / 2; i++) {
				x += worms[order[i]].x;
				y += worms[order[i]].y;
			}
			WORM left = new WORM(x, y);
			
			x = 0;	y = 0;
			for(int i = 0; i < N; i++) {
				if(!selected[i]) {
					x += worms[i].x;
					y += worms[i].y;
				}
			}
			WORM right = new WORM(x, y);
			
			WORM result = minus(left, right);
			MIN = (long) Math.min(size(result), MIN);
			selected = new boolean[N];
			return;
		}
		for (int i = before; i < N; i++) {
			if(index == 0 && i != 0) return;
			order[index] = i;
			combi(i + 1, index + 1);
		}
	}

	public static WORM minus(WORM w1, WORM w2) {
		return new WORM(w1.x - w2.x, w1.y - w2.y);
	}

	public static long size(WORM w) {
		long x = (w.x * w.x);
		long y = (w.y * w.y);
		
		return (long) x+y;
	}
}
