package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class D3_1216_회문2 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1216.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			char[][] arr = new char[100][];
			for (int i = 0; i < 100; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			int maxLen = 0;
			next_line:
			for (int i = 0; i < 100; i++) {
				for (int len = 100; len >= maxLen; len--) {
					for (int pos = 0; pos <= 100-len; pos++) {
						boolean yes = true;
						int lpos = pos;
						int rpos = pos+len-1;
						while(lpos < rpos) {
							if(arr[i][lpos] != arr[i][rpos]) {
								yes = false;
								break;
							}
							lpos++;
							rpos--;
						}
						if(yes) {
							maxLen = len;
							continue next_line;
						}
					}
				}
			}
			next_line:
			for (int i = 0; i < 100; i++) {
				for (int len = 100; len >= maxLen; len--) {
					for (int pos = 0; pos <= 100-len; pos++) {
						boolean yes = true;
						int lpos = pos;
						int rpos = pos+len-1;
						while(lpos < rpos) {
							if(arr[lpos][i] != arr[rpos][i]) {
								yes = false;
								break;
							}
							lpos++;
							rpos--;
						}
						if(yes) {
							maxLen = len;
							continue next_line;
						}
					}
				}
			}
			bw.write(String.format("#%d %d\n", test_case, maxLen));
			bw.flush();
		}
	}
}
