package __SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리 {
	static class EDGE implements Comparable<EDGE> {
		int leftOne, rightOne;
		int number, value;

		public EDGE(int leftOne, int rightOne, int number, int value) {
			this.leftOne = leftOne;
			this.rightOne = rightOne;
			this.number = number;
			this.value = value;
		}

		@Override
		public int compareTo(EDGE o) {
			return this.value - o.value;
		}
	}

	static int[] parents; // 부모 노드의 위치를 기억할 배열
	// SW_Expert는 Solution

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			long answer = 0;
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			EDGE[] edges = new EDGE[E];
			int edgeCnt = 0;

			parents = new int[V+1];
			Arrays.fill(parents, -1); // -1(음수)이면 root노드임을 의미

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new EDGE(from, to, i, weight);
			}
			Arrays.sort(edges);
			
			int select = -1;
			while (edgeCnt != V - 1) {
				select++;
				if (union(edges[select].leftOne, edges[select].rightOne)) {
					edgeCnt++;
					answer += edges[select].value;
				}
			}
			System.out.println("#" + test_case + " " + answer);

		}
	}

	private static boolean union(int a, int b) {
		// 2. Find Set : 자신이 속한 집합 찾기
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot) { // 3. Union Set : 두 노드의 집합이 다르면 합치기
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parents[a] < 0)
			return a; // Root 노드에 도달하면 반환되기 시작함
		// Root노드가 아니면 부모노드 따라가서 루트노드 알아와 지정

		return parents[a] = find(parents[a]); // Path Compression
	}
}
/*
2
7 11
5 3 18
1 2 21
2 6 25
0 2 31
0 1 32
3 4 34
5 4 40
2 4 46
0 6 51
4 6 51
0 5 60
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 4
1 4 6
2 3 2
2 4 -3
3 4 1
*/