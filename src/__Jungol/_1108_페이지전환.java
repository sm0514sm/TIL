package __Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class _1108_페이지전환 {
	static int[][] click;
	static int N, minIdx = Integer.MAX_VALUE, maxIdx;
	static int MAX = 9999999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		click = new int[500 + 1][500 + 1];
		for(int i = 0; i < 501; i++)
			Arrays.fill(click[i], MAX);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			minIdx = Math.min(minIdx, Math.min(from, to));
			maxIdx = Math.max(maxIdx, Math.max(from, to));
			click[from][to] = 1;
		}
		for(int i = minIdx; i <= maxIdx; i++) {
			for(int from = minIdx; from <= maxIdx; from++) {
				if(click[from][i] == MAX) continue;
				for(int to = minIdx; to <= maxIdx; to++) {
					if(from == to) continue;
					if(click[from][i] + click[i][to] < click[from][to])
						click[from][to] = click[from][i] + click[i][to];
				}
			}
		}
		int sum = 0;
		for(int i = minIdx; i <= maxIdx; i++) {
			for(int j = minIdx; j <= maxIdx; j++) {
				if(i == j) continue;
				sum += click[i][j];
			}
		}
		int cnt = maxIdx - minIdx + 1;
		System.out.printf("%.3f", (double) sum/(cnt*(cnt-1)));
	}// END main

}
