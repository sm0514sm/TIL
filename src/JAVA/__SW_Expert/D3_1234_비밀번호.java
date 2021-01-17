package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1234_비밀번호 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			LinkedList<Character> list = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			String str = st.nextToken();
			for (int i = 0; i < str.length(); i++) {
				list.add(str.charAt(i));
			}
			for (int j = 0; j < str.length()/2; j++) {
				for (int i = 1; i < list.size(); i++) {
					if(list.get(i) == list.get(i-1)) {
						list.remove(i);
						list.remove(i-1);
						break;
					}
				}
			}
			bw.write("#" + test_case + " ");
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i) + "");
			}
			bw.write("\n");
			bw.flush();
		}
	}
}
