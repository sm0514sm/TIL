package __Jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class _1681_해밀턴순환회로 {
	static int N, min;
	static int[][] map;
	static int[] order;
	static final int  MAX = 9999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		map = new int[N][N];
		order = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = map[i][j] == 0? MAX: map[i][j];
			}
		}
		dfs(0, 0, 0);
		System.out.println(min);
	}
	private static void dfs(int vertex, int flag, int sum) {
		if(sum >= min) return;
		flag |= 1 << vertex;
		if(flag == (2 << N-1) - 1) {
			sum += map[vertex][0];
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(i == vertex) continue;
			if((flag & (1 << i)) > 0) continue;
			if(map[vertex][i] == MAX) continue;
			dfs(i, flag | (1 << i), sum + map[vertex][i]);
		}
		
	}
}
/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
*/