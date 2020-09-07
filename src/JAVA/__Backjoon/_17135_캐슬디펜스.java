package __Backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _17135_캐슬디펜스 {
	static int[][] arr;
	static int[][] backArr;
	static int N, M, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 200][M + 200];
		backArr = new int[N + 200][M + 200];
		for (int i = 100; i < N + 100; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 100; j < M + 100; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				backArr[i][j] = arr[i][j];
			}
		}
		selected = new int[3];
		combi(0, 0);

		bw.write(String.format("%d \n", max));
		bw.flush();
	}

	static int[] selected;
	static int max = 0, count;

	private static void combi(int before, int index) {
		if (index == 3) {
			count = 0;
			for (int i = 100; i < N + 100; i++) {
				for (int j = 100; j < M + 100; j++) {
					arr[i][j] = backArr[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				shot();
				nextTurn();
			}
			max = Math.max(max, count);
			return;
		}
		for (int i = before; i < M; i++) {
			selected[index] = i + 100;
			combi(i + 1, index + 1);

		}
	}
	// 가장 가까운 적 쏘기 
	// 가장 가까운 적이 여럿이면 왼쪽에 쏘기임
	private static void shot() {
		next: for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= D; j++) {
				int startR = N + 100 - 1;
				int startC = selected[i] - j + 1;
				// 왼쪽
				for (int k = 1; k < j; k++) {
					if(arr[startR][startC] >= 1) {
						arr[startR][startC]++;
						continue next;
					}
					startR--;
					startC++;
				}
				startR = N + 100 - j;
				startC = selected[i];
				// 위 오른쪽
				for (int k = 0; k < j; k++) {
					if(arr[startR][startC] >= 1) {
						arr[startR][startC]++;
						continue next;
					}
					startR++;
					startC++;
				}
			}
		}
	}

	private static void nextTurn() {
		for (int i = N + 100; i > 100; i--) {
			for (int j = 100; j < M + 100; j++) {
				if (arr[i-1][j] > 1) {
					count++;
					arr[i-1][j] = 0;
				}
				arr[i][j] = arr[i-1][j];
			}
		}
		Arrays.fill(arr[0 + 100], 0);
	}
}
