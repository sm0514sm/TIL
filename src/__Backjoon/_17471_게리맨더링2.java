package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Main
public class _17471_게리맨더링2 {
	static int N, ans;
	static int[] cnt; // 인구수
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cnt = new int[N + 1];
		ans = Integer.MAX_VALUE;
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++)
			cnt[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][tmp] = 1;
			}
		}
		int loopCnt = 1 << N;
		for (int i = 1; i < loopCnt - 1; i++) {
			doit(i);
		}
		System.out.println(ans == Integer.MAX_VALUE? -1: ans);
	}

	static ArrayList<Integer> aList, bList;
	static int aCnt, bCnt, visit, pA, pB;

	private static void doit(int flag) {
		aList = new ArrayList<>();
		bList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) >= 1)
				aList.add(i + 1);
			else
				bList.add(i + 1);
		}
		aCnt = bCnt = visit = pA = pB = 0;
		
		visit = 0;
		dfs(aList, aList.get(0), true);
		if (aList.size() != aCnt)
			return;
		
		visit = 0;
		dfs(bList, bList.get(0), false);
		if (bList.size() != bCnt)
			return;
		
		ans = Math.min(ans, Math.abs(pA - pB));
	}

	private static void dfs(ArrayList<Integer> list, int num, boolean type) {
		visit |= 1 << num;
		
		if (type) {
			aCnt++;
			pA += cnt[num];
		} else {
			bCnt++;
			pB += cnt[num];
		}
		
		for (int i = 1; i <= N; i++) {
			if(!list.contains(i) || map[num][i] == 0 || (visit & 1 << i) > 0 ) continue;
			dfs(list, i, type);
		}
	}

}