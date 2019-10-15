package __Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Main
public class _14889_스타트와링크 {
	static int N, MIN, tempSum;
	static int[][] arr;
	static int[] one, two, temp;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		MIN = Integer.MAX_VALUE;
		arr = new int[N][N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		combi(0, 0);
		System.out.println(MIN);
	}

	private static void combi(int before, int index) {
		if(index == N /2) {
			one = new int[N/2];
			two = new int[N/2];
			int oneCnt = 0;
			int twoCnt = 0;
			for (int i = 0; i < N; i++) {
				if(selected[i])
					one[oneCnt++] = i;
				else
					two[twoCnt++] = i;
			}
			MIN = Math.min(MIN, Math.abs(Sum(one) - Sum(two)));
			return;
		}
		for (int i = before + 1; i <= N; i++) {
			selected[i-1] = true;
			combi(i, index+1);
			selected[i-1] = false;
		}
	}

	private static int Sum(int[] one) {
		tempSum = 0;
		temp = new int[2];
		permutation_flag(0, 0, one);
		
		return tempSum;
	}

	private static void permutation_flag(int index, int flag, int[] one) {
		if(index == 2) {
			tempSum += arr[temp[0]][temp[1]];
			return;
		}
		
		for(int i = 0; i < N/2; i++) {
			if((flag & 1 << i) > 0) continue;
			temp[index] = one[i];
			permutation_flag(index + 1, flag | 1 << i, one);
		}
	}
}
