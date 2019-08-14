package _SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2001_파리퇴치 {
	static int arr[][], N, M, row, col;
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_2001.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(row = 0; row < N - M + 1; row++) {
				for(col = 0; col < N - M + 1; col++) {
					answer = Math.max(answer, getKillCount());
				}
			}
			
			bw.write(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
	public static int getKillCount() {
		int sum = 0;
		for(int i = row; i < row + M; i++) {
			for(int j = col; j < col + M; j++) {
				sum += arr[i][j];
			}
		}
		
		return sum;
	}
}
