package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_6730_장애물경주난이도 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int up = 0;
			int down = 0;
			for (int i = 1; i < N; i++) {
				if(arr[i-1] < arr[i]) {
					up = Math.max(up, arr[i]-arr[i-1]);
				}
				else
					down = Math.max(down, arr[i-1]-arr[i]);
			}
			bw.write(String.format("#%d %d %d\n", test_case, up, down));
			bw.flush();
		}
	}
}
