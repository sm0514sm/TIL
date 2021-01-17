package ___Essential;
/**
 * 음의 가중치가 없는 그래프에서 한 노드에서 다른 모든 노드까지의 최단거리를 구하는 알고리즘
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _06_다익스트라 {

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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int end = N - 1;
		int[][] adjMatrix = new int[N][N]; // 인접행렬
		boolean[] visited = new boolean[N]; // 정점방문여부
		int[] distance = new int[N]; // 시작정점에서 각정점까지 이르는 최소비용
		final int INF = Integer.MAX_VALUE;

		Arrays.fill(distance, INF);
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		} // i노드에서 j노드들까지 비용 저장


		distance[0] = 0; // 출발정점 : 0~0까지의 최소비용 0으로 처리
		
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		queue.offer(new Vertex(0, distance[0]));		
		while(!queue.isEmpty()) {													
			// 1. 방문하지 않는 정점 중 최소가중치의 정점 선택
			Vertex current = queue.poll();
			if(visited[current.vertex]) continue;
			
			visited[current.vertex] = true;
			if(current.vertex == end) break;
			
			
			// 2. current 정점을 경유지로 하여 갈 수 있는 다른 방문하지 않는 정점들에 대한 고려
			for (int j = 0; j < N; j++) {
				// min에는 0부터 current까지 가는 최소값을 가지고 있음
				if (!visited[j] && 										// 방문하지 않은 j정점
						adjMatrix[current.vertex][j] != 0 && 					// current와 입접한 j정법
						current.weight + adjMatrix[current.vertex][j] < distance[j]) { 	// 시작~current~j 비용<시작~비용
					distance[j] = current.weight + adjMatrix[current.vertex][j];
					queue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}


}
