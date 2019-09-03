package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_1213_String {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			int answer = 0;
			String find = br.readLine();
			String text = br.readLine();
			text = text.replaceAll(find, "*");
			for (int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == '*')
					answer++;
			}
			bw.append(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
