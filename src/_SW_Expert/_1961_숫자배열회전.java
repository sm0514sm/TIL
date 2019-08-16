package _SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1961_숫자배열회전 {
	static int[][] arr, arr90, arr180, arr270;
	static int N;
	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			N = Integer.parseInt(br.readLine());
			arr    = new int[N][N];
			arr90  = new int[N][N];
			arr180 = new int[N][N];
			arr270 = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			rotate90(arr, arr90);
			rotate90(arr90, arr180);
			rotate90(arr180, arr270);
			
			bw.write("#" + test_case + "\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) bw.write(arr90[i][j] + "");
				bw.write(" ");
				for(int j = 0; j < N; j++) bw.write(arr180[i][j] + "");
				bw.write(" ");
				for(int j = 0; j < N; j++) bw.write(arr270[i][j] + "");
				bw.write("\n");
			}
			bw.flush();
		}
	}
	private static void rotate90(int[][] before, int[][] after) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				after[j][N-i-1] = before[i][j];
			}
		}
	}
}
