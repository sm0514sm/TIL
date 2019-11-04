package 못푼문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3812_호중이의큐브색칠2 {
	static int X, Y, Z, A, B, C, N;
	static int[][] tmpans;
	static long[] oneAns;
	static long[] realAns;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());
			Z = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			// 크기 N^3 일 때의 답을 구하자
			tmpans = new int[N][N];
			oneAns = new long[N];
			realAns = new long[N];
			// 중앙 라인 구하기
			for (int x = 0; x < X; x++) {
				oneAns[(Math.abs(x-A)+Math.abs(B-B)) % N]++;
				realAns[(Math.abs(x-A)+Math.abs(B-B)) % N]++;
			}
			// 중앙 위 구하기
			for (int i = B+1; i < Y; i++) {
				int cnt = 1;
				for (int j = 0; j < N; j++) {
					realAns[(j + cnt) % N] += oneAns[j];
				}
			}
			// 중앙 아래 구하기
			for (int i = B - 1; i >= 0; i--) {
				int cnt = 1;
				for (int j = 0; j < N; j++) {
					realAns[(j+cnt) % N] += oneAns[j];
				}
			}
			oneAns = realAns.clone();
			
			// 중앙 위 구하기
			for (int i = C+1; i < Z; i++) {
				int cnt = 1;
				for (int j = 0; j < N; j++) {
					realAns[(j+cnt) % N] += oneAns[j];
				}
			}
			// 중앙 아래 구하기
			for (int i = C - 1; i >= 0; i--) {
				int cnt = 1;
				for (int j = 0; j < N; j++) {
					realAns[(j+cnt) % N] += oneAns[j];
				}
			}
			
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(realAns[i] + " ");
			}
			System.out.println();
		}
	}
}
