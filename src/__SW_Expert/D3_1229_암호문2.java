package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D3_1229_암호문2 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int cmd = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmd; i++) {
				char command = st.nextToken().charAt(0);
				int pos, cnt;
				switch (command) {
				case 'I':
					pos = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						list.add(pos+j, Integer.parseInt(st.nextToken()));
					}
					break;
				case 'D':
					pos = Integer.parseInt(st.nextToken());
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						list.remove(pos);
					}
					break;
				case 'A':
					cnt = Integer.parseInt(st.nextToken());
					for (int j = 0; j < cnt; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			StringBuilder build = new StringBuilder();
			build.append("#");
			build.append(test_case);
			build.append(" ");
			for (int i = 0; i < 10; i++) {
				build.append(list.get(i) + " ");
			}
			build.append("\n");
			bw.write(build.toString());
			bw.flush();
		}
	}
}
