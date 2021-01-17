package __SW_Expert;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D4_5215_햄버거다이어트 {
			//SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] food = new int[N][2];	// 0은 점수, 1은 칼로리
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				food[i][0] = Integer.parseInt(st.nextToken());
				food[i][1] = Integer.parseInt(st.nextToken());
			}
			int[][] arr = new int[N+1][L];
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < L; j++) {
					if(j - food[i-1][1] >= 0)
						arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-food[i-1][1]] + food[i-1][0]);
					else
						arr[i][j] = arr[i-1][j];
				}
			}
			System.out.println("#" + test_case + " " + arr[N][L-1]);
		}
	}
}
