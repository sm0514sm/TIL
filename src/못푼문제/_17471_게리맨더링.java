package 못푼문제;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _17471_게리맨더링 {
	static int N, ans;
	static boolean possible;
	static int[] cnt;	// 인구수
	static int[][] map;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cnt = new int[N+1];
		ans = Integer.MAX_VALUE;
		map = new int[N+1][N+1];
		
		
		boolean possible = false;
		for (int i = 1; i <= N; i++) {
			cnt[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][tmp] = 1;
			}
		}
		
		
		dfs(1, (1 << 1));
		if(possible) {
			System.out.println(ans);
		}
		else
			System.out.println(-1);
		
	}

	private static void dfs(int num, int flag) {
		//flag 안된 것들이 연결 될 수 있는지 확인
		// 연결될 수 없으면 return
		
		int blue = 0;
		int red = 0;
		if(flag == Math.pow(2, N+1) - 2)
			possible = true;
		for (int i = 1; i <= N; i++) {
			if((flag & (1 << i)) > 0)
				red += cnt[i];
			else
				blue += cnt[i];
		}
		ans = Math.min(ans, Math.abs(red - blue));
		if(ans == 0) return;
		
		for (int i = 1; i <= N; i++) {
			if(i == num) continue;
			if(map[num][i] != 1) continue;
			if((flag & (1 << i)) > 0) continue;
			
			dfs(i, flag | (1 << i));
		}
	}
	
	
}
