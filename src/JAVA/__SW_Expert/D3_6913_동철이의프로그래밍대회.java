package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_6913_동철이의프로그래밍대회 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int max = 0;
			int maxCnt = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					sum += Integer.parseInt(st.nextToken());
				}
				if(sum > max) {
					max = sum;
					maxCnt = 1;
				}
				else if(sum == max) {
					maxCnt++;
				}
			}
			
			
			bw.append(String.format("#%d %d %d\n", test_case, maxCnt, max));
			bw.flush();
		}
	}
}
