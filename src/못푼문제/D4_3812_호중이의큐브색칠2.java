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
/*
1
5 5 5 0 0 0 7
#1 1 9 25 25 25 24 16 
1
5 5 5 0 0 0 7
#1 19 18 16 16 18 19 19
 * */
			
			// 중앙 위 구하기
			int mul = 0;
			int temp1 = (Y - (B+1))/ N;
			int temp2 = (B)/ N;
			mul = temp1 + temp2;
			for (int j = 0; j < N; j++) {
				realAns[j] += (mul)*N * realAns[j];
			}
			int cnt = 0;
			for (int i = temp1 * N + B+1; i < Y; i++) {
				cnt++;
				for (int j = 0; j < N; j++) {
					realAns[(j+cnt) % N] += oneAns[j];
				}
			}
			// 중앙 아래 구하기
			cnt = 0;
			for (int i = B-1 - temp2 * N; i >= 0; i--) {
				cnt++;
				for (int j = 0; j < N; j++) {
					realAns[(j+cnt) % N] += oneAns[j];
				}
			}
			oneAns = realAns.clone();
			
			// 중앙 위 구하기
			mul = 0;
			temp1 = (Z - (C+1))/ N;
			temp2 = (C)/ N;
			mul = temp1 + temp2;
			for (int j = 0; j < N; j++) {
				realAns[j] += (mul)*N * realAns[j];
			}
			cnt = 0;
			for (int i = temp1 * N + C+1; i < Z; i++) {
				cnt++;
				for (int j = 0; j < N; j++) {
					realAns[(j+cnt) % N] += oneAns[j];
				}
			}
			// 중앙 아래 구하기
			cnt = 0;
			for (int i = C - 1 - temp2 * N; i >= 0; i--) {
				cnt++;
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
