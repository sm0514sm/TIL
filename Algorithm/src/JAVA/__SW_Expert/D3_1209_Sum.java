package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_1209_Sum {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			int answer = 0;
			int[][] arr  = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				answer = Math.max(sum, answer);
			}
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				answer = Math.max(sum, answer);
			}
			int sum = 0;
			for (int i = 0; i < 100; i++) sum += arr[i][i];
			answer = Math.max(sum, answer);
			sum = 0;
			for (int i = 0; i < 100; i++) sum += arr[i][99-i];
			answer = Math.max(sum, answer);
			
			bw.append(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
