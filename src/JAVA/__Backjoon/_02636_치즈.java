package __Backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _02636_치즈 {
	
	static int N, M, arr[][];
	static int[][] DIR = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int cheeseCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1)
					cheeseCnt++;
			}
		}
		int time = 0;
		int lastCheeseCnt = 0;
		while(cheeseCnt != 0) {
			lastCheeseCnt = cheeseCnt;
			bfs(0, 0);
			time++;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < M; j++)
					if(arr[i][j] == 2) arr[i][j] = 0;
		}
		System.out.println(time);
		System.out.println(lastCheeseCnt);
	}
	private static void bfs(int r, int c) {
		Queue<int[]> Q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		Q.offer(new int[] {r, c});
		visited[r][c] = true;
		while(!Q.isEmpty()) {
			int[] temp = Q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + DIR[i][0];
				int nc = temp[1] + DIR[i][1];
				if(nr >= N || nc >= M || nr < 0 || nc < 0) continue;
				if(arr[nr][nc] == 1) {
					arr[nr][nc] = 2;
					cheeseCnt--;
				}
				else if(visited[nr][nc] == false && arr[nr][nc] == 0){
					Q.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
}
