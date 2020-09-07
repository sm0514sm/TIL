package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D2_1984_중간평균값구하기 {
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream(".txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine().trim()); test_case <= T; test_case++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			int min = 10000;
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				max = Math.max(max, num);
				min = Math.min(min, num);
				answer += num;
			}
			answer -= max;
			answer -= min;
			answer = Math.round((float)answer / 8f);
			bw.write(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
