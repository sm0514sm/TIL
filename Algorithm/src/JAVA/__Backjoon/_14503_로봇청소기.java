package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _14503_로봇청소기 {
	static int N, M, r, c, dir, cnt;
	static boolean visited[][];
	static int[][] map;
	static int[][] DIR = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		next:
		while(true) {
//			청소한다
			if(!visited[r][c]) {
				visited[r][c] = true;
				cnt++;
			}
			int ndir = dir;
			int rotateCnt = 0;
			for (rotateCnt = 0; rotateCnt < 4; rotateCnt++) {
				ndir += 3;
				ndir %= 4;
				int nr = r + DIR[ndir][0];
				int nc = c + DIR[ndir][1];
//				a 인경우
				if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
					dir = ndir;
					r = nr;
					c = nc;
					continue next;
				}
				else {
					continue;
				}
			}
			if(rotateCnt == 4) {
				int nr = r - DIR[dir][0];
				int nc = c - DIR[dir][1];
				if(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
					r = nr;
					c = nc;
					continue next;
				}
				else
					break;
			}
			
		}
		System.out.println(cnt);
	}
}
/*
3 3
1 1 0
0 0 1
1 0 1
1 1 1

4 5
3 2 0
1 1 1 1 1
1 0 0 0 0 
1 0 0 0 1 
1 0 0 1 1

 */