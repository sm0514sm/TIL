// 쌤의 풀이 (nextPermutation)
package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D5_1247_최적경로_TC2 {
	static class Location {
		int x, y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static Location start, end, customers[], distance[];
	static int N, min, order[];

	// SW_Expert는 Solution
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rsc/_SW_Expert_1247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		for (int test_case = 1, T = Integer.parseInt(br.readLine()); test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			order = new int[N];
			distance = new Location[N+2];
			distance[0] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			distance[N+1] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			customers = new Location[N];
			
			for (int i = 0; i < N; i++) {
				order[i] = i + 1;
				customers[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			/*--- 데이터 입력 완료 ---*/
			per_loop:
			do{
				int sum = 0;
				for (int i = 0; i < N; i++)
					distance[order[i]] = customers[i];

				for (int i = 0; i < N + 1; i++) {
					sum += getDistance(distance[i], distance[i + 1]);
					if(sum >= min) continue per_loop;
				}
				min = Math.min(min, sum);
			}while (nextPermutation());

			bw.write(String.format("#%d %d\n", test_case, min));
			bw.flush();
		}
	}

	private static boolean nextPermutation() {
		int i = N-1;
		while(i > 0 && order[i-1] >= order[i]) i--;
		if(i == 0)	return false;
		
		int j = N-1;
		while(order[i-1] >= order[j]) j--;
		swap(i-1, j);
		
		j = N-1;
		while(i < j) swap(i++, j--);
		
		return true;
	}
	
	private static int getDistance(Location from, Location to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
	}

	public static void swap(int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}
}
