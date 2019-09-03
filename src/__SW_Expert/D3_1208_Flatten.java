package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_1208_Flatten {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			int flatten = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			for (int i = flatten; i > 0; i--) {
				arr[0]++;
				arr[99]--;
				Arrays.sort(arr);
			}
			answer = arr[99] - arr[0];
			
			bw.append(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
