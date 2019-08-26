package __SW_Expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1251_하나로 {
	public static class ISLAND implements Comparable<ISLAND> {
		int x, y, num;

		public ISLAND() {}

		@Override
		public int compareTo(ISLAND o) {
			return 0;
		}
	}
	
	public static class EDGE implements Comparable<EDGE>{
		ISLAND left, right;
		double len;
		public EDGE(ISLAND left, ISLAND right) {
			super();
			this.left = left;
			this.right = right;
			this.len = getDistance(this.left, this.right);
		}
		
		@Override
		public int compareTo(EDGE o) {
			if(this.len < o.len)			return -1;
			else if(this.len > o.len)		return 1;
			else							return 0;
		}
	}
	
	static int[] arr = new int[2];
	static int N, cnt, parents[];
	static ISLAND[] islands;
	static EDGE[] edges;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1251.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			double answer = 0;
			N = Integer.parseInt(br.readLine());
			islands = new ISLAND[N];
			edges = new EDGE[N*(N-1)/2];
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				islands[j] = new ISLAND();
				islands[j].x = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				islands[j].y = Integer.parseInt(st.nextToken());
				islands[j].num = j;
			}
			double e = Double.parseDouble(br.readLine());
			combination(0,0);
			Arrays.sort(edges);
			
			parents = new int[N];
            Arrays.fill(parents, -1);
            int edgeCnt = 0;
            int select = -1;
            while (edgeCnt != N - 1) {
                select++;
                if (union(edges[select].left.num, edges[select].right.num)) {
                    edgeCnt++;
                    answer += Math.pow(edges[select].len,2);
                }
            }
            long ans = Math.round(answer * e);
            System.out.println("#" + test_case +" " + ans);
		}
	}
	private static void combination(int before, int index) {
		if(index == 2) {
			edges[cnt++] = new EDGE(islands[arr[0]], islands[arr[1]]);
			return;
		}
		for(int i = before; i < N; i++) {
			arr[index] = i;
			combination(i + 1, index+1);
		}
	}
	private static double getDistance(ISLAND island, ISLAND island2) {
		return Math.sqrt(Math.pow((island.x - island2.x), 2)+Math.pow((island.y - island2.y), 2));
	}
	
	private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parents[bRoot] = aRoot;
            return true;
        }
        return false;
    }
 
    private static int find(int a) {
        if (parents[a] < 0)
            return a;
        return parents[a] = find(parents[a]); // Path Compression
    }
}
