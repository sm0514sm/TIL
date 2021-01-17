package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D2_1859_백만장자프로젝트 {
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			
			long answer = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] price = new int[N];
			int[] whomax = new int[N];
			for (int i = 0; i < N; i++)
				price[i] = Integer.parseInt(st.nextToken());
			int count = 0;
			int max = 0;
			int[] dp = new int[N];
			for(int i = N-1; i >= 0; i--) {
				if(i == N-1) {
					dp[i] = i;
					continue;
				}
				if(price[i] < price[dp[i+1]])	dp[i] = dp[i+1];	// 우측에서 제일 큰값보다 작은 경우
				else							dp[i] = i;			// 우측에서 제일 큰값보다   큰 경우
			}
			for(int i = 0; i < N; i++) {
				answer += price[dp[i]] - price[i];
			}
			bw.write("#"+test_case+" " + answer + " \n");
			bw.flush();
		}
		bw.close();
	}

}
