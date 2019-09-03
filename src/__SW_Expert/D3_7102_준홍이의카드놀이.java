package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_7102_준홍이의카드놀이 {
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N + M + 1];
			for (int i = 1; i <= N; i++)
				for (int j = 1; j <= M; j++)
					arr[i+j]++;
			int max = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i <= N+M; i++) {
				if(max < arr[i]) {
					q.clear();
					max = arr[i];
					q.offer(i);
				}
				else if (max == arr[i]) {
					q.offer(i);
				}
			}

			bw.append("#" + test_case + " ");
			while(!q.isEmpty()) {
				bw.append(q.poll() + " ");
			}
			bw.append("\n");
			bw.flush();
		}
	}
}
