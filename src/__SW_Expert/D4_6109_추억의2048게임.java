package __SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_6109_추억의2048게임 {
	static int N, dir;
	static int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int[][] map;
	static boolean[][] fixed;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			fixed = new boolean[N][N];
			String temp = st.nextToken();
			if (temp.equals("up"))			dir = 0;
			else if (temp.equals("down"))	dir = 1;
			else if (temp.equals("left"))	dir = 2;
			else if (temp.equals("right"))	dir = 3;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			// 상
			if (dir == 0) {
				for (int j = 0; j < N; j++) {
					for (int i = 1; i < N; i++) {
						if(map[i][j] == 0) continue;
						int nr = i;
						while (true) {
							nr += DIR[dir][0];
							if (nr >= N || nr < 0)	break;
							if (map[nr][j] == 0)	{
								map[nr][j] = map[nr - DIR[dir][0]][j];
								map[nr - DIR[dir][0]][j] = 0;
								continue;
							}
							else if (fixed[nr][j])	break;
							else if (map[nr][j] == map[nr - DIR[dir][0]][j]) {
								map[nr][j] *= 2;
								fixed[nr][j] = true;
								map[nr - DIR[dir][0]][j] = 0;
								break;
							}
						}
					}
				}
			}
			else if(dir == 1) {
				for (int j = 0; j < N; j++) {
					for (int i = N-2; i >= 0; i--) {
						if(map[i][j] == 0) continue;
						int nr = i;
						while (true) {
							nr += DIR[dir][0];
							if (nr >= N || nr < 0)	break;
							if (map[nr][j] == 0)	{
								map[nr][j] = map[nr - DIR[dir][0]][j];
								map[nr - DIR[dir][0]][j] = 0;
								continue;
							}
							else if (fixed[nr][j])	break;
							else if (map[nr][j] == map[nr - DIR[dir][0]][j]) {
								map[nr][j] *= 2;
								fixed[nr][j] = true;
								map[nr - DIR[dir][0]][j] = 0;
								break;
							}
						}
					}
				}
			}
			else if(dir == 2) {
				for (int i = 0; i < N; i++) {
					for (int j = 1; j < N; j++) {
						if(map[i][j] == 0) continue;
						int nc = j;
						while (true) {
							nc += DIR[dir][1];
							if (nc >= N || nc < 0)	break;
							if (map[i][nc] == 0)	{
								map[i][nc] = map[i][nc - DIR[dir][1]];
								map[i][nc - DIR[dir][1]] = 0;
								continue;
							}
							else if (fixed[i][nc])	break;
							else if (map[i][nc] == map[i][nc - DIR[dir][1]]) {
								map[i][nc] *= 2;
								fixed[i][nc] = true;
								map[i][nc - DIR[dir][1]] = 0;
								break;
							}
						}
					}
				}
			}
			else if(dir == 3) {
				for (int i = 0; i < N; i++) {
					for (int j = N-2; j >= 0; j--) {
						if(map[i][j] == 0) continue;
						int nc = j;
						while (true) {
							nc += DIR[dir][1];
							if (nc >= N || nc < 0)	break;
							if (map[i][nc] == 0)	{
								map[i][nc] = map[i][nc - DIR[dir][1]];
								map[i][nc - DIR[dir][1]] = 0;
								continue;
							}
							else if (fixed[i][nc])	break;
							else if (map[i][nc] == map[i][nc - DIR[dir][1]]) {
								map[i][nc] *= 2;
								fixed[i][nc] = true;
								map[i][nc - DIR[dir][1]] = 0;
								break;
							}
						}
					}
				}
			}
			sb.append("#" + test_case + "\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
