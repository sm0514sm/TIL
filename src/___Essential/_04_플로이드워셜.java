package ___Essential;

import java.util.Arrays;

/**
 * 그래프에서 가능한 모든 노드 쌍에 대해 최단 거리를 구하는 알고리즘
 * 경유지 > 출발지 > 목적지 순의 3중 반복문 사용
 * 시간 복잡도 : O(V^3)
 * 음의 사이클 없어야함
 * @author 상민
 */
public class _04_플로이드워셜 {
	static final int INF = 9999999;
	static int[][] adjMatrix = {{0,   INF,  -2, INF},
								{4,     0,   3, INF},
								{INF, INF,   0,   2},
								{INF,  -1, INF,   0}};
	
	public static void main(String[] args) {
		int len = adjMatrix.length;
		for (int k = 0; k < len; k++) {
			for (int i = 0; i < len; i++) {
				if(i == k) continue;
				for (int j = 0; j < len; j++) {
					if(i == j || j == k) continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
				}
			}
		}
		for (int i = 0; i < len; i++) {
			System.out.println(Arrays.toString(adjMatrix[i]));
		}
	}
}
