package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * nCr = nC(n-r)이므로
 * nC1 ~ nC(n/2) 까지만 조합을 구하면 된다.
 * 1. 지역구 나누기
 * 2. 지역구에 속한 지역 인접 여부 검사 => 그래프 탐색
 * 	  - 하나의 지역구라도 인접 X면 다음 지역구의 조합 보기
 *    - 두 지역구 모두 인접 O면
 * 3. 지역구 A, B의 인구수 차이 최소값 반영
 */

//Main
public class _17471_게리맨더링_쌤풀이 {
	static int N, ans;
	static boolean possible;
	static int[] cnt; // 인구수
	static int[][] map;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		cnt = new int[N + 1];
		ans = Integer.MAX_VALUE;
		map = new int[N + 1][N + 1];
		selected = new boolean[N + 1];

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
		for (int i = 1; i <= N / 2; i++) {
			// nCi
			divide(0, 0, i);
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	private static void divide(int index, int cnt, int target) {
		if (cnt == target) {
			compare();
			return;
		}
		for (int i = index; i < N; i++) {
			selected[i] = true;
			divide(i + 1, cnt + 1, target);
			selected[i] = false;
		}
	}
	static int visited, pA, pB, countA, countB;
	
	private static void compare() {
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			if(selected[i]) aList.add(i);
			else bList.add(i);
		}
		countA = countB = pA = pB = 0;
		
		visited = 0;	// 비트 마스킹으로
//		dfs(aList, aList.get(0), true);		// type(true, false)가 A지역구, B지역구 판단
		bfs(aList, true);
		if(countA != aList.size()) return;
		
		visited = 0;
//		dfs(bList, bList.get(0), true);
		bfs(bList, true);
		if(countB != bList.size()) return;
		
		// 두 지역구가 각각 인접한 경우
		if(ans > Math.abs(pA - pB))
			ans = Math.abs(pA - pB);
	}

	private static void dfs(ArrayList<Integer> list, int v, boolean type) { // v : 탐색 시작점
		visited |= 1 << v;
		if(type) {
			countA++;
			pA += cnt[v];
		}else {
			countB++;
			pB += cnt[v];
		}
		
		for (int i = 0; i < N; i++) {
			//나와 같은 지역구고 && 연결되어있고 && 방문하지 않은 경우
			if(list.contains(i) && map[v][i] > 0 && (visited & 1 << i) == 0)
				dfs(list, i, type);
		}
	}
	
	private static void bfs(ArrayList<Integer> list, boolean type) {
		Queue<Integer> queue = new LinkedList<>();
		int start = list.get(0);
		queue.offer(start);
		visited |= 1 << start;
		while(!queue.isEmpty()) {
			int pop = queue.poll();
			if(type) {
				countA++;
				pA += cnt[pop];
			}else {
				countB++;
				pB += cnt[pop];
			}
			for (int i = 0; i < N; i++) {
				if(list.contains(i) && map[pop][i] > 0 && (visited&1<<i) == 0) {
					visited |= 1 << i;
					queue.offer(i);
				}
			}
		}
	}
}
