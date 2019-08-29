package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D3_1220_Magnetic {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = 10; test_case <= T; test_case++) {
			int answer = 0;
			int[][] MAP = new int[100][100];
			br.readLine();
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					MAP[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 100; i++) {
				boolean good = false;
				for (int j = 0; j < 100; j++) {
					if(!good && MAP[j][i] == 1)
						good = true;
					else if(good && MAP[j][i] == 2) {
						good = false;
						answer++;
					}
				}
			}
			bw.write(String.format("#%d %d\n", test_case, answer));
		}
		bw.flush();
	}
}
