package _SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1983_조교의성적매기기{
	public static void reverse(double[] arr) {
		int size = arr.length;
		for(int i = 0; i < size/2; i++) {
			double temp = arr[i];
			arr[i] = arr[size-i-1];
			arr[size-i-1] = temp;
		}
	}
			//SW_Expert는 Solution
	public static void main(String[] args)  throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_1983.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			double[] arr = new double[N+1];
			for(int i = 1; i < N +1; i++){
				st = new StringTokenizer(br.readLine());
				arr[i] += Double.parseDouble(st.nextToken())*0.35;
				arr[i] += Double.parseDouble(st.nextToken())*0.45;
				arr[i] += Double.parseDouble(st.nextToken())*0.20;
			}
			double findValue = arr[K];
			Arrays.sort(arr);
			reverse(arr);
			int count = N/10;
			int cnt = 0;
			for(int j = 0; j < N+1; j++) {
				cnt++;
				if(arr[j] == findValue) break;
				if(cnt == count) {
					cnt = 0;
					answer++;
				}
				
			}
			bw.write(String.format("#%d %s\n", test_case, grade[answer]));
			bw.flush();
		}
	}

}
