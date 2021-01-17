package __Jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class _1733_오목 {
	static int[][] map;
	static int[][] DIR = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[19][19];
		StringTokenizer st = null;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if(map[i][j] == 0) continue;
				int select = map[i][j];
				for (int dir = 0; dir < DIR.length; dir++) {
					int cnt = 1;
					int nr = i;
					int nc = j;
					while(true) {
						nr += DIR[dir][0];
						nc += DIR[dir][1];
						if(nr >= 19 || nc >= 19 || nr < 0 || nc < 0) break;
						if(map[nr][nc] != select) break;
						cnt++;
						
					}
					nr = i;
					nc = j;
					if(cnt == 5) {
						nr -= DIR[dir][0];
						nc -= DIR[dir][1];
						if(nr >= 19 || nc >= 19 || nr < 0 || nc < 0 || map[nr][nc] != select) {
							System.out.println(select);
							System.out.println((i+1) + " " + (j+1));
							return;
						}
					}
				}
			}
		}
		System.out.println(0);
	}
	
}
