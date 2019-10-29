package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_4613_러시아국기같은깃발 {
	static int N, M;
	static int[][] colors;	// W, B, R
	static int ans;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			colors = new int[N][3];
			M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				for (int j = 0; j < M; j++) {
					switch (temp.charAt(j)) {
						case 'W': colors[i][0]++;	break;
						case 'B': colors[i][1]++;	break;
						case 'R': colors[i][2]++;	break;
					}
				}
			}
			int tempAns = 0;
			for (int blueSize = 1; blueSize <= N-2; blueSize++) {
				for (int pos = 1; pos < N-blueSize; pos++) {
					tempAns = 0;
					for (int whitePos = 0; whitePos < pos; whitePos++)
						tempAns += colors[whitePos][1]+colors[whitePos][2];
					for (int bluePos = pos; bluePos < pos + blueSize; bluePos++)
						tempAns += colors[bluePos][0]+colors[bluePos][2];
					for (int redPos = pos + blueSize; redPos < N; redPos++)
						tempAns += colors[redPos][0]+colors[redPos][1];
					ans = Math.min(ans, tempAns);
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
