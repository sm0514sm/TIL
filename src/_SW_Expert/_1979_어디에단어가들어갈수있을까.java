package _SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1979_어디에단어가들어갈수있을까 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1979.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j< N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int row = 0; row < N; row++) {
				int count = 0;
				for(int col = 0; col < N; col++) {
					if(arr[row][col] == 0) { count = 0; continue;}
					count++;
					if(count == K && (col+1 >= N || arr[row][col + 1] == 0)) {
						answer++;
						count = 0;
					}
				}
			}
			for(int col = 0; col < N; col++) {
				int count = 0;
				for(int row = 0; row < N; row++) {
					if(arr[row][col] == 0) { count = 0; continue;}
					count++;
					if(count == K && (row+1 >= N || arr[row + 1][col] == 0)) {
						answer++;
						count = 0;
					}
				}
			}
			bw.write(String.format("#%d %d\n", test_case, answer));
			bw.flush();
		}
	}
}
