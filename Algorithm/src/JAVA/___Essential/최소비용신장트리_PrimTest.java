// 최적화 버전
package ___Essential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용신장트리_PrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N]; // 인접행렬
		boolean[] visited = new boolean[N]; // 정점방문여부
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		} // i노드에서 j노드들까지 비용 저장 

		int cnt = 0, result = 0;
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
		// 임의의 정점(0)을 첫정점으로 선택
		Q.offer(new Vertex(0, 0));

		while (!Q.isEmpty()) {
			Vertex current = Q.poll(); // 최소비용의 정점 선택
			
			if(visited[current.vertex]) continue;	// 현정점이 이미 처리된 정점이면 다음 poll
			
			result += current.weight;
			visited[current.vertex] = true;
			if(++cnt == N) break;
			
			for (int i = 0; i < N; i++) {
				// 현재 버텍스와 연결되어있고 방문하지 않았다면
				if (!visited[i] && adjMatrix[current.vertex][i] != 0) {
					Q.offer(new Vertex(i, adjMatrix[current.vertex][i]));
				}
			}
		}
		System.out.println(result);
	}// END main

	static class Vertex implements Comparable<Vertex> {
		int vertex, weight;

		public Vertex(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

}
