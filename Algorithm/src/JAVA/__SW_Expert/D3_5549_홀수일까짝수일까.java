package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_5549_홀수일까짝수일까 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			String answer = null;
			String str = br.readLine();
			if((str.charAt(str.length()-1) - '0') % 2 == 0)
				answer = "Even";
			else
				answer = "Odd";
			
			
			bw.append(String.format("#%d %s\n", test_case, answer));
			bw.flush();
		}
	}
}
