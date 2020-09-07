package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_7728_다양성측정 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			String str = br.readLine();
			boolean[] arr = new boolean[10];
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i)-'0'] = true;
			}
			for (int i = 0; i < 10; i++) {
				if(arr[i])
					answer++;
			}
			
			bw.write(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
