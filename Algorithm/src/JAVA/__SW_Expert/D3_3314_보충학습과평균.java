package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_3314_보충학습과평균 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 5; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num < 40) num = 40;
				answer += num;
			}
			
			bw.append(String.format("#%d %d\n", test_case, answer/5));
			bw.flush();
		}
	}
}
