package ___Essential;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 그래프에서 한 노드에서 다른 모든 노드까지의 최단거리를 구하는 알고리즘
 * 음수의 사이클이 존재하면 안됨
 * 입력받은 edge(from, to, weight)를 N-1번 반복해서 구함
 * (N번 반복했는데도 줄어든다면 음의 사이클이 존재하는 것)
 * 
 * 기능 : 다익스트라 + 음의 가중치 = 벨만포드
 * 속도 : 다익스트라 >> 벨만포드
 */
/* 예시
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
*/
//Main
public class _05_벨만포드 {
	static int count, edgeCount;
	static final int INF = 9999999;
	static int[] distance;	// 1번 도시에서 각 도시로 가는 최소시간
	static Edge[] edges;
	
	static class Edge{
		int from, to, time;
		public Edge(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		count = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		distance = new int[count];
		edges = new Edge[edgeCount];
		
		for (int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()) - 1,
								Integer.parseInt(st.nextToken()) - 1, 
								Integer.parseInt(st.nextToken()));
		}
		
		Arrays.fill(distance, INF);
		distance[0] = 0;
		if(goNegetiveCycle()){
			System.out.println(-1);
		}
		else {
			for (int d = 1; d < count; d++) {
				System.out.println(d+1 + "까지 거리 : " + (distance[d] == INF? -1: distance[d]));
			}
		}
	}

	private static boolean goNegetiveCycle() {
		// count - 1 번까지 줄어드는 것은 음수 사이클인지 그냥 최적길 찾은건지 모르지만
		// count 번에서 줄어드는 것은 반드시 음수 사이클이 존재하는 것을 의미함
		for (int i = 1; i <= count; i++) {
			// 한 주기마다 edges 입력받은거 설정해주기
			for (Edge e : edges) {
				if(distance[e.from] == INF) continue;
				if(distance[e.from] + e.time < distance[e.to]) {
					distance[e.to] = distance[e.from] + e.time;
					if(i == count) return true;
				}
			}
		}
		
		return false;
	}
}
