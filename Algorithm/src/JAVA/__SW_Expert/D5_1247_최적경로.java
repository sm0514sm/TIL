package __SW_Expert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {
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
			min = 100000;
			order = new int[N];
			start = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -1);
			end = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -1);
			customers = new Location[N];
			for (int i = 0; i < N; i++) {
				order[i] = i;
				customers[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
			}
			/*--- 데이터 입력 완료 ---*/
			permutation(0);

			bw.write(String.format("#%d %d\n", test_case, min));
			bw.flush();
		}
	}

	private static int getDistance(Location from, Location to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
	}

	public static void permutation(int index) {
		if (N == index) {
			int sum = getDistance(start, customers[order[0]]);
			for (int i = 0; i < N - 1; i++) {
				if (sum >= min)
					return;
				sum += getDistance(customers[order[i]], customers[order[i + 1]]);
			}
			sum += getDistance(end, customers[order[N - 1]]);
			if (sum >= min)
				return;
			min = Math.min(min, sum);
			return;
		}
		for (int i = index; i < N; i++) {
			swap(index, i);
			permutation(index + 1);
			swap(index, i);
		}
	}

	public static void swap(int i, int j) {
		int temp = order[i];
		order[i] = order[j];
		order[j] = temp;
	}
}
