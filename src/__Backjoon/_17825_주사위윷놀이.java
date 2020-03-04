package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Main
public class _17825_주사위윷놀이 {
	static int[][] map = {	{ 0,  0,  0,  0,  0,   0,  0,  0,  0,  0,  0},
							{ 0,  0,  0,  0,  0,  40,  0,  0,  0,  0,  0},
							{ 2,  0,  0,  0,  0,   0, 38,  0,  0,  0,  0},
							{ 4,  0,  0,  0,  0,  35,  0, 36,  0,  0,  0},
							{ 6,  0,  0,  0,  0,  30,  0,  0, 34,  0,  0},
							{ 8,  0,  0,  0,  0,   0,  0,  0,  0, 32,  0},
							{10,  0, 13, 16, 19,  25, 26, 27, 28,  0, 30},
							{ 0, 12,  0,  0,  0,   0,  0,  0,  0, 28,  0},
							{ 0,  0, 14,  0,  0,  24,  0,  0, 26,  0,  0},
							{ 0,  0,  0, 16,  0,  22,  0, 24,  0,  0,  0},
							{ 0,  0,  0,  0, 18,   0, 22,  0,  0,  0,  0},
							{ 0,  0,  0,  0,  0,  20,  0,  0,  0,  0,  0}};
	static int[][] visited;
	static int[][] DIR = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {-1,1}, {-1, -1}};	// 하 우 좌 상 우하 우상 좌상
	
	static class Horse{
		int r, c, dir;

		public Horse(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		public boolean go(int count) {
			int befR = r;
			int befC = c;
			visited[r][c] = 0;
			for (int cnt = 1; cnt <= count; cnt++) {
				int nr = r + DIR[dir][0];
				int nc = c + DIR[dir][1];
				if(nr >= 12 || nc >= 11 || nr < 0 || nc < 0) continue;
				switch (map[nr][nc]) {
					case 0:	
						if(nr == 0) break;
						cnt--;	
						break;
					case 10:
						if(cnt == count) dir = 1;
						else dir = 4;
						break;
					case 20:
						if(cnt == count) dir = 3;
						else dir = 5;
						break;
					case 25:
						dir = 3;
						break;
					case 30:
						if(nr != 6) break;
						if(cnt == count) dir = 2;
						else dir = 6;
						break;
					case 40:
						dir = 3;
						break;
				}
				r = nr;
				c = nc;
			}
			if(visited[r][c] == 1 && map[r][c] != 0) return false;
			if(befR != r || befC != c)
				sum += map[r][c];
			visited[r][c] = 1;
			return true;
		}
		
	}
	static Horse[] horses;
	static int[] orders, command;
	static int max, sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		command = new int[10];
		for (int i = 0; i < 10; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		orders = new int[10];
		horses = new Horse[4];
		
		orders[0] = 0;
		perm(1);
		System.out.println(max);
	}
	private static void perm(int index) {
		if(index == 10) {
			visited = new int[12][11];
			for (int i = 0; i < 4; i++) {
				horses[i] = new Horse(0, 0, 0);
			}
			sum = 0;
			for (int i = 0; i < 10; i++) {
				if(!horses[orders[i]].go(command[i])) 
					return;
			}
			if(max < sum)
				max = sum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			orders[index] = i;
			perm(index+1);
		}
	}
}
