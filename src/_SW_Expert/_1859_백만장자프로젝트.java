package _SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1859_백만장자프로젝트 {
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
			int sum = 0;
			int count = 0;
			int max = 0;
			int[] dp = new int[N];

//			for (int i = 0; i < N-1; i++) {
//				if(price[i] <= price[i+1]) {
//					sum += price[i];
//					count++;
//				}
//				else {
//					answer += count * price[i] - sum;
//					sum = 0;
//					count = 0;
//				}
//			}
			
			bw.write("#"+test_case+" " + sum + " \n");
			bw.flush();
		}
		bw.close();
	}

}
