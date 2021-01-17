package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_4406_모음이보이지않는사람 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			String txt = br.readLine();
			String answer = "";
			for (int i = 0; i < txt.length(); i++) {
				if(txt.charAt(i) == 'a') continue;
				if(txt.charAt(i) == 'e') continue;
				if(txt.charAt(i) == 'i') continue;
				if(txt.charAt(i) == 'o') continue;
				if(txt.charAt(i) == 'u') continue;
				answer += txt.charAt(i);
			}
			
			
			bw.write(String.format("#%d %s\n", test_case, answer));
			bw.flush();
		}
	}
}
