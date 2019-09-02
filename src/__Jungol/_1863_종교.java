package __Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1863_종교 {
	static int[] parents; // 부모 노드의 위치를 기억할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[50001];
		parents = new int[N+1];
		Arrays.fill(parents, -1); 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a < b)
				union(a, b);
			else
				union(b, a);
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(arr[find(i)] == 0) {
				arr[find(i)] = 1;
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean union(int a, int b) {
		// 2. Find Set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {		// 3. Union Set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0) return a;	// Root 노드에 도달하면 반환되기 시작함
		
		return parents[a] = find(parents[a]);	// Path Compression 
	}
}
