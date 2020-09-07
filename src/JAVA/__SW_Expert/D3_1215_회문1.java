package __SW_Expert;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D3_1215_회문1 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			int answer = 0;
			ArrayList<Character> list = new ArrayList<Character>();
			int len = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			for(int i = 0; i < 8; i++)
				arr[i] = br.readLine().toCharArray();
			//가로검사
			for(int i = 0; i < 8; i++) {
				list.clear();
				next_word:
				for(int j = 0; j < 8; j++) {
					if(list.size() != len) {
						list.add(arr[i][j]);
					}
					if(list.size() == len) {
						for(int k = 0; k < len/2; k++)
							if(list.get(k) != list.get(len-1-k)) {
								list.remove(0);
								continue next_word;
							}
						list.remove(0);
						answer++;
					}
				}
			}
			//세로검사
			for(int i = 0; i < 8; i++) {
				list.clear();
				next_word:
				for(int j = 0; j < 8; j++) {
					if(list.size() != len) {
						list.add(arr[j][i]);
					}
					// len과 같다면
					if(list.size() == len) {
						for(int k = 0; k < len/2; k++)
							if(list.get(k) != list.get(len-1-k)) {
								list.remove(0);
								continue next_word;
							}
						list.remove(0);
						answer++;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
