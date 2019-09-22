// 쌤의 풀이
package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D5_1247_최적경로_TC {
	static class Location {
		int x, y, index;

		public Location(int x, int y, int index) {
			this.x = x;
			this.y = y;
			this.index = index;
		}

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static Location start, end, customers[];
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
			start = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -1);
			end = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -1);
			customers = new Location[N];
			for (int i = 0; i < N; i++) {
				order[i] = i;
				customers[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			/*--- 데이터 입력 완료 ---*/
			go(0, start.x, start.y, 0, 0);

			bw.write(String.format("#%d %d\n", test_case, min));
			bw.flush();
		}
	}
//	bx, by는 이전에 들린 곳 
	private static void go(int count, int bx, int by, int visited, int result) {
		if(result >= min)	return;
		if(count == N) {
			result += Math.abs(end.x - bx) + Math.abs(end.y - by);
			if(result < min)	min = result;
			return;
		}
		for (int i = 0; i < N; i++) {
			if((visited & 1 << i) == 0) {	// 방문하지 않은 고객집
				go(count + 1, customers[i].x, customers[i].y,
						visited | 1 << i,
						result + Math.abs(customers[i].x - bx) + Math.abs(customers[i].y - by));	// 순서가 여기에 적용됨
			}
		}
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
