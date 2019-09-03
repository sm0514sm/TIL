package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_5431_민석이의과제체크하기 {
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[] sended = new boolean[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				sended[Integer.parseInt(st.nextToken())] = true;
			}

			bw.append("#" + test_case + " ");
			for (int i = 1; i <= N; i++) {
				if(!sended[i])
					bw.append(i + " ");
			}
			bw.append("\n");
			bw.flush();
		}
	}
}
