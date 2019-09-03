package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_1206_View {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());	
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i < arr.length-2; i++) {
				if(arr[i] == 0) continue;
				int max = 0;
				for (int j = i-2; j <= i+2; j++) {
					if(j == i) continue;
					max = Math.max(max, arr[j]);
				}
				int dif = arr[i]-max;
				answer += dif > 0 ? dif: 0;
			}
			bw.append(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
