import java.util.Arrays;

public class Solution_3번문제 {
	public static int[][] DIR = {{-1, 0}, {1, 0}, {0,1}, {0, -1}};
	public static int[][] map;
	public static boolean[][] visited;
	public static int max = 0;
	public static int solution(int[][] board) {
		max = 0;
		map = board;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				visited = new boolean[4][4];
				dfs(i, j, 1);
			}
		}
		if(max == 1)
			return -1;
		return max;
	}


	private static void dfs(int i, int j, int cnt) {
		visited[i][j] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = i + DIR[dir][0];
			int nc = j + DIR[dir][1];
			if(nr >= 4 || nc >= 4 || nr < 0 || nc < 0) continue;
			if(visited[nr][nc]) continue;
			if(map[nr][nc] != map[i][j]) continue;
			dfs(nr, nc, cnt+1);
		}
		max = Math.max(cnt, max);
	}


	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{3,2,3,2}, {2,1,1,2}, {1,1,2,1}, {4,1,1,1}}));
		System.out.println(solution(new int[][] {{4,2,3,2}, {2,1,2,4}, {1,2,3,1}, {4,1,4,3}}));
	}

}
