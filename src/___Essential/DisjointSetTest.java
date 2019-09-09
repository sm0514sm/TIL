package ___Essential;
import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetTest {
	static int[] parents; // 부모 노드의 위치를 기억할 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = sc.nextInt();

		parents = new int[N];

		// 1. Make set : 원소들 각각 개별적인 집합으로 만듬 (자기자신이 루트노드)
		Arrays.fill(parents, -1); // -1(음수)이면 root노드임을 의미

		for (int i = 0; i < count; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(union(a, b));
		}
		System.out.println(find(0) + " // " + find(1));
		System.out.println(find(3) + " // " + find(4));
		System.out.println(find(2) + " // " + find(3));
		sc.close();
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
		// Root노드가 아니면 부모노드 따라가서 루트노드 알아와 지정
		return parents[a] = find(parents[a]);	// Path Compression 
	}
}
