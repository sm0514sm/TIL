package __SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class 모의_5656_벽돌깨기 {
	static int N, W, H, brickCnt, tempCnt, ans;
	static int[][] originalArr, tempArr;
	static int[] 폭탄위치;
	static int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			brickCnt = 0;
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			originalArr = new int[H][W];
			폭탄위치 = new int[N];
			ans = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					originalArr[i][j] = Integer.parseInt(st.nextToken());
					if(originalArr[i][j] != 0)
						brickCnt++;
				}
			}
			permu(0);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	static Queue<int[]> Q;
	static boolean[][] visited;

	private static void permu(int index) {
		if (index == N) {
			Q = new LinkedList<>();
			tempArr = new int[H][W];
			tempCnt = brickCnt;
			for (int r = 0; r < H; r++) {
				tempArr[r] = originalArr[r].clone();
			}
			for (int cnt = 0; cnt < N; cnt++) {
				visited = new boolean[H][W];
				폭탄떨구기(폭탄위치[cnt]);
				while(!Q.isEmpty()) {
					boom(Q.poll());
				}
				내리기();
			}
			ans = Math.min(ans, tempCnt);
			return;
		}
		for (int i = 0; i < W; i++) {
			폭탄위치[index] = i;
			permu(index + 1);
		}
	}

	private static void 폭탄떨구기(int col) {
		for (int r = 0; r < H; r++) {
			if(tempArr[r][col] != 0) {
				Q.offer(new int[] {r, col});
				break;
			}
		}
	}
	
	private static void boom(int[] pop) {
		visited[pop[0]][pop[1]] = true;
		int power = tempArr[pop[0]][pop[1]];
		tempArr[pop[0]][pop[1]] = 0;
		tempCnt--;
		
		for (int dir = 0; dir < 4; dir++) {
			int nr;
			int nc;
			for (int p = 1; p < power; p++) {
				nr = pop[0] + DIR[dir][0]*p;
				nc = pop[1] + DIR[dir][1]*p;
				if(nr >= H || nc >= W || nr < 0 || nc < 0) break;
				if(tempArr[nr][nc] == 0 || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				Q.offer(new int[] {nr, nc});
			}
		}
		
	}

	private static void 내리기() {
		for (int col = 0; col < W; col++) {
			int cnt = 1;
			for (int row = H-1; row >= 0; row--) {
				if(tempArr[row][col] != 0) continue;
				for (int r = row-cnt; r >= 0; r--) {
					if(tempArr[r][col] == 0) cnt++;
					else {
						tempArr[row][col] = tempArr[r][col];
						tempArr[r][col] = 0;
						break;
					}
				}
			}
		}
	}
}
