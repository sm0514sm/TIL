package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_6719_성수의프로그래밍강좌시청 {
	static int N, K;
	static int[] level;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			level = new int[N];
		
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				level[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(level);
			double lv = 0;
			for (int i = N - K; i < N; i++) {
				lv = (lv + level[i])/ 2;
			}
			System.out.println("#" + test_case + " " + lv);
		}
	}
}
