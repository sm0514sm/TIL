package __SW_Expert;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 모의_2105_디저트카페 {
	static int[][] map, DIR = { { 1, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 } };
	static int N;
	static int max, POSSIBLE;

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("rsc/_SW_Expert_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			POSSIBLE = 2*N-2;
			max = 1;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			search:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N ; j++) {
					if(max == POSSIBLE) break search;
					doit(i, j);
				}
			}
			max = max == 1? -1 : max;
			System.out.println("#" + test_case + " " + max);

		}
	}

	private static void doit(int r, int c) {
		int 왼쪽아래 = 0;
		int 오른쪽아래 = 0;
		while(true) {
			오른쪽아래 = 0;
			왼쪽아래++;
			if(r + DIR[0][0]*왼쪽아래>= N || c + DIR[0][1] * 왼쪽아래 < 0) break;
			next:
			while(true) {
				오른쪽아래++;
				
				if(r + DIR[0][0]*왼쪽아래 + DIR[1][0] * 오른쪽아래 >= N || c + DIR[0][1] * 왼쪽아래 + DIR[1][1] *오른쪽아래 >= N ) break;
				if(max == (왼쪽아래 + 오른쪽아래)*2) continue;
				ArrayList<Integer> path = new ArrayList<>();
				path.add(map[r][c]);
				int nr = r, nc = c;
				for (int cnt = 1; cnt <= 왼쪽아래; cnt++) {
					nr +=DIR[0][0];
					nc +=DIR[0][1];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue next;
					if(path.contains(map[nr][nc])) continue next;
					path.add(map[nr][nc]);
				}
				for (int cnt = 1; cnt <= 오른쪽아래; cnt++) {
					nr += DIR[1][0];
					nc += DIR[1][1];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue next;
					if(path.contains(map[nr][nc])) continue next;
					path.add(map[nr][nc]);
				}
				for (int cnt = 1; cnt <= 왼쪽아래; cnt++) {
					nr +=DIR[2][0];
					nc +=DIR[2][1];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue next;
					if(path.contains(map[nr][nc])) continue next;
					path.add(map[nr][nc]);
				}
				for (int cnt = 1; cnt <= 오른쪽아래 - 1; cnt++) {
					nr +=DIR[3][0];
					nc +=DIR[3][1];
					if(nr >= N || nc >= N || nr < 0 || nc < 0) continue next;
					if(path.contains(map[nr][nc])) continue next;
					path.add(map[nr][nc]);
				}
				max = Math.max(max, path.size());
				if(max == POSSIBLE) return;
			}
		}
	}
}
